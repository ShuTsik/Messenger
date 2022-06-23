package com.pawel;

public enum EnumValidation {
    PASSWORDTOOSHORT("Podane haslo jest zbyt krotkie"),
    PASSWORDTOOLONG("Podane haslo jest zbyt dlugie"),
    USERNAMETOOSHORT("Podany login jest zbyt krotki"),
    USERNAMETOOLONG("Podany login jest zbyt dlugi"),
    USERNAMENOTUNIQUE("Podany login jest juz zajety");

    public final String statement;
    EnumValidation(String statement) {
    this.statement = statement;
    }

}
