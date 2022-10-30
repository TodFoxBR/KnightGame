package com.knightgame.br.states;

public enum LoginState {

    LOGGED_IN, NOT_LOGGED_IN;

    public static LoginState state = NOT_LOGGED_IN;

    public static String loggedInPlayerName = "";
}
