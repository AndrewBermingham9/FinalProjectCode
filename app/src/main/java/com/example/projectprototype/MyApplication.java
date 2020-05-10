package com.example.projectprototype;


import android.app.Application;

class MyApplication extends Application {

        private String m_player1name;
        private String m_player2name;

        public String getM_player1name() {
            return m_player1name;
        }

        public void setM_player1name(String str) {
            m_player1name = str;
        }

    public String getM_player2name() {
        return m_player2name;
    }

    public void setM_player2name(String m_player2name) {
        this.m_player2name = m_player2name;
    }
}

