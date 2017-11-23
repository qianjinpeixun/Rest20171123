package com.qianjin.java.sss.java2s.a1101.ass42larryla;

public class Computer {

    public static int getColum(Chip[][] a) {
        int bestColumn = 0;
        bestColumn = find1(a, "R");
        if (bestColumn != -1) {
            return bestColumn;
        }

        bestColumn = find1(a, "Y");
        if (bestColumn != -1) {
            return bestColumn;
        }

        bestColumn = find2(a);
        return bestColumn;
    }

    public static int find2(Chip[][] a) {
        int no = (int) (Math.random() * 6);
        return no;
    }

    public static int find1(Chip[][] a, String colo) {
        int position = -1;
        boolean b = false;
        int xx = 0;
        int yy = 0;
        for (int i = 0; i < 6; i++) {// rows
            // cols because it will plus 1 or 2 or 3 so,it must be 4
            for (int j = 0; j < 5; j++) {
                if (a[i][j] != null && a[i][j].getChip().equalsIgnoreCase(colo))
                    continue;
                if (a[i][j] != null && a[i][j + 1] != null && a[i][j + 2] != null) {
                    // if that 4 not equals to null and they are equals
                    if (a[i][j].equals(a[i][j + 1])) {
                        if (a[i][j + 1].equals(a[i][j + 2])) {

                            b = true;
                            xx = i;
                            yy = j;
                            int checkx = xx;
                            int checky = 0;

                            if (xx == 5 || xx == 0)
                                checkx = xx;
                            else
                                checkx = xx + 1;

                            if (yy == 0 || yy == 6) {
                                checky = 3;
                            } else {
                                checky = yy - 1;
                                if (a[checkx][checky] == null) {
                                    return checky;
                                }
                                checky = yy + 3;
                                if (checkx < 6 && checky < 7 && checkx >= 0 && checky >= 0)
                                    if (a[checkx][checky] == null) {
                                        return checky;
                                    }
                            }
                        }
                    }

                }
            }

        }

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 4; x++) {// same method with last one
                if (a[x][y] != null && a[x][y].getChip().equalsIgnoreCase(colo))
                    continue;
                if (a[x][y] != null && a[x + 1][y] != null && a[x + 2][y] != null) {
                    if (a[x][y].equals(a[x + 1][y])) {
                        if (a[x + 1][y].equals(a[x + 2][y])) {
                            b = true;
                            xx = x;
                            yy = y;
                            int checkx = xx - 1;
                            int checky = yy;
                            if (checkx > 0)
                                if (a[checkx][checky] == null) {
                                    if (a[0][checky] == null)
                                        return checky;
                                }
                        }
                    }
                }
            }

        }

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 5; j++) {// same method with last one
                if (a[i][j] != null && a[i][j].getChip().equalsIgnoreCase(colo))
                    continue;
                if (a[i][j] != null && a[i - 1][j + 1] != null && a[i - 2][j + 2] != null) {
                    if (a[i][j].equals(a[i - 1][j + 1])) {
                        if (a[i - 1][j + 1].equals(a[i - 2][j + 2])) {

                            b = true;
                            xx = i;
                            yy = j;
                            int checkx = xx - 3;
                            int checky = yy + 3;
                            if (checkx >= 0 && checky <= 6) {
                                if (a[checkx + 1][checky] != null||a[checkx][checky]==null)
                                    return checky;
                            }
                            checkx = xx + 1;
                            checky = yy - 1;

                            if (checkx < 6 && checky >= 0) {
                                int nx = checkx + 1;
                                if (nx > 5)
                                    nx = 5;
                                if (a[nx][checky] != null||a[checkx][checky]==null) {
                                    return checky;
                                }
                            }
                        }
                    }
                }
            }

        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {// same method with last one
                if (a[i][j] != null && a[i][j].getChip().equalsIgnoreCase(colo))
                    continue;
                if (a[i][j] != null && a[i + 1][j + 1] != null && a[i + 2][j + 2] != null) {
                    if (a[i][j].equals(a[i + 1][j + 1])) {
                        if (a[i + 1][j + 1].equals(a[i + 2][j + 2])) {
                            xx = i;
                            yy = j;
                            int checkx = xx - 1;
                            int checky = yy - 1;
                            if (checkx >= 0 && checky >= 0 && checkx < 6 && checky < 7) {
                                if (a[checkx + 1][checky] != null&&a[checkx][checky]==null) {
                                    return checky;
                                }
                            }

                            checkx = xx + 3;
                            checky = yy + 3;
                            if (checkx < 6 && checky < 6 && checkx >= 0 && checky >= 0) {
                                if (a[checkx + 1][checky] != null&&a[checkx][checky]==null) {
                                    return checky;
                                }
                            }

                        }
                    }
                }
            }
        }

        return -1;
    }

}
