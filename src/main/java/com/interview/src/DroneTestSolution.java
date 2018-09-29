package com.interview.src;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DroneTestSolution {

    static class Coordinates {

        int x, y;

        Coordinates (int argX, int argY) {
            this.x = argX;
            this.y = argY;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinates {" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        private static double calcEuclidian(Coordinates c1, Coordinates c2){
            double  xDiff = c1.getX()-c2.getX();
            double  xSqr  = Math.pow(xDiff, 2);

            double yDiff = c1.getY()-c2.getY();
            double ySqr = Math.pow(yDiff, 2);

            double output   = Math.sqrt(xSqr + ySqr);

            Double truncatedDouble = BigDecimal.valueOf(output)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            System.out.println("euclidean distance: " + truncatedDouble);

            return truncatedDouble;
        }
    }

    static void fly(String commands) {
        /*
         * Write your code here.
         */
        Coordinates initial = new Coordinates(0,0);
        String[] cmdArr = commands.split(" ");
        for(int i=0;i <cmdArr.length;i++) {
            System.out.println("(" + initial.getX() + "," + initial.getY() + ")");
            String direction = cmdArr[i];
            if (direction.equals("N")) {
                initial.setY(initial.getY() + 1);
            } else if (direction.equals("S")) {
                initial.setY(initial.getY() - 1);
            } else if (direction.equals("W")) {
                initial.setX(initial.getX() - 1);
            } else if (direction.equals("E")) {
                initial.setX(initial.getX() + 1);
            }
        }
        System.out.println("(" + initial.getX() + "," + initial.getY() + ")");

        Coordinates.calcEuclidian(new Coordinates(0,0),initial);
    }

    public static void main(String[] args) {
        DroneTestSolution.fly("N N W N");
        DroneTestSolution.fly("N W N N");
    }

}
