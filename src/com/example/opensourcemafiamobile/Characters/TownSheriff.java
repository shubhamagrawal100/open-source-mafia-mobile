package com.example.opensourcemafiamobile.Characters;

import java.util.Scanner;

import com.example.opensourcemafiamobile.*;

public class TownSheriff extends AbstractPlayer {
	
	private MainActivity main;

    // Public getter
    public TownSheriff(MainActivity main) {
        this.main = main;
    }

    // Name of target to investigate (displayed at end of each round since Framer can skew results)
    String target;
    
    public TownSheriff(String playerName) {
        this.setAffiliation( "Town" );
        this.setRole( "Sheriff" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setFramed( false );
        this.setPlayerName( playerName );
            
        addToTownList( this );
    }
    
    public TownSheriff(String playerName, MainActivity main) {
    	this.main = main;
        this.setAffiliation( "Town" );
        this.setRole( "Sheriff" );
        this.setDead( false );
        this.setDoused( false );
        this.setHealed( false );
        this.setFramed( false );
        this.setPlayerName( playerName );
            
        addToTownList( this );
    }

    // Investigate
    public String nightActionString() {
        return null;
    }

    @Override
    public void nightAction() {
//        @SuppressWarnings("resource")
//        Scanner in = new Scanner( System.in );
        main.outputText( getPlayerName() + ": Enter name of player to investigate." );
//        target = in.nextLine();
    }
    
    public String getTarget() {
        return this.target;
    }
    
    public void investigationResults() {
        for ( int i = 0; i < MainActivity.getTownList().size(); i++ ) {

            if ( target.equals( ( MainActivity.getTownList().get( i ) ).getPlayerName() ) ) {
                main.outputText( target + " was investigated and was discovered to be from the "
                        + MainActivity.getTownList().get( i ).getAffiliation() + "." );
            }
        }

        for ( int i = 0; i < MainActivity.getMafiaList().size(); i++ ) {

            if ( target.equals( ( MainActivity.getMafiaList().get( i ) ).getPlayerName() ) ) {
                main.outputText( target + " was investigated and was discovered to be from the "
                        + MainActivity.getMafiaList().get( i ).getAffiliation() + "." );
            }
        }
    }
}
