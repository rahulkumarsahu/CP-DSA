package org.practice.cpdsa.queue;

public class QueueUnderFlowException extends Exception {

    public QueueUnderFlowException(String message) {
        super(message);
    }
}
