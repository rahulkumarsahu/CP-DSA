package org.practice.cpdsa.company.google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        int output = getReachedEmailAddress(emails);
        System.out.println(output);
    }

    private static int getReachedEmailAddress(String[] emails) {
        Set<String> output = new HashSet<>();

        for (String email : emails) {
            if(email.contains("@")) {
                String domainName = email.substring(email.indexOf("@") + 1);
                String localName = email.substring(0, email.indexOf("@") - 1);

                if(localName.contains(".")) {
                  localName = localName.replace(".", "");
                }
                if(localName.contains("+")) {
                   localName = localName.substring(0, localName.indexOf("+") - 1);
                }

                String result = localName.concat("@").concat(domainName);
                output.add(result);
            }
        }

        return output.size();
    }
}
