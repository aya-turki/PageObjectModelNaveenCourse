package com.qa.java.customerexceptions;


    public class FrameworkException extends RuntimeException {

        public FrameworkException(String messg){
            super(messg);
            printStackTrace();
        }
}
