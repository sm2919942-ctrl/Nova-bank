package com.novabank.backend.util;

import java.time.LocalDate;
import java.util.Random;

    public class AccountGenerator {

        public static String generateAccountNumber() {

            Random random = new Random();

            return "50" + (1000000000L + random.nextInt(900000000));

        }

        public static String generateCustomerId() {

            Random random = new Random();

            return "CUST" + (100000 + random.nextInt(900000));

        }

        public static String generateIFSC() {

            return "NOVA0001234";

        }

        public static String createdDate() {

            return LocalDate.now().toString();

        }

    }

