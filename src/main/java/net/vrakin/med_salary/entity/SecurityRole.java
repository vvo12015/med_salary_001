package net.vrakin.med_salary.entity;

public enum SecurityRole {

    ADMIN, SMALL_ADMIN, USER;

    @Override
    public String toString() {
        return "ROLE_" + this.name();
    }
}
