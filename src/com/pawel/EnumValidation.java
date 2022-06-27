package com.pawel;

public enum EnumValidation {
    PASSWORD_TOO_SHORT("Podane haslo jest zbyt krotkie"),
    PASSWORD_TOO_LONG("Podane haslo jest zbyt dlugie"),
    USERNAME_TOO_SHORT("Podany login jest zbyt krotki"),
    USERNAME_TOO_LONG("Podany login jest zbyt dlugi"),
    USERNAME_NOT_UNIQUE("Podany login jest juz zajety"),
    FIELD_IS_EMPTY("Pole nie moze byc puste"),
    WRONG_IDENTITIES("Podane login lub haslo jest nieprawidlowe");

    public final String statement;
    EnumValidation(String statement) {
    this.statement = statement;
    }

}
