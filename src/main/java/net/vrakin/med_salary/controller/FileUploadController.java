package net.vrakin.med_salary.controller;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.domain.NszuDecryption;
import net.vrakin.med_salary.excel.NszuDecryptionExcelReader;
import net.vrakin.med_salary.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping
@Slf4j
public class FileUploadController {

    private final StorageService storageService;

    private final NszuDecryptionExcelReader nszuDecryptionExcelReader;

    @Autowired
    public FileUploadController(StorageService storageService,
                                NszuDecryptionExcelReader nszuDecryptionExcelReader) {
        this.storageService = storageService;
        this.nszuDecryptionExcelReader = nszuDecryptionExcelReader;
    }

    @GetMapping("/files")
    public String listUploadedFiles(Model model){

        model.addAttribute("files", storageService.loadAll().map(
                        path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                                "serveFile", path.getFileName().toString()).build().toUri().toString())
                .collect(Collectors.toList()));
        log.info("Accessing upload page");

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);

        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/files")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam(value = "corrective", required = false) boolean corrective,
                                   @RequestParam String monthYear,
                                   RedirectAttributes redirectAttributes) {

        YearMonth yearMonth = YearMonth.parse(monthYear);
        int monthNumber = yearMonth.getMonthValue();
        int yearNumber = yearMonth.getYear();
        String savedFileName = String.format("%s_%d_%02d.xslx", corrective?"correct":"decryption", yearNumber, monthNumber);

        File destinationFile = storageService.store(file, savedFileName);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + savedFileName + "!");
        List<NszuDecryption> nszuList = nszuDecryptionExcelReader.readAllEntries(destinationFile);
        redirectAttributes.addFlashAttribute("nszuList", nszuList);

        return "redirect:/files";
    }

}