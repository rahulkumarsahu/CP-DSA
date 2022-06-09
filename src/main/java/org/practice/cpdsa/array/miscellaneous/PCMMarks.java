package org.practice.cpdsa.array.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PCMMarks {

    public void customSort (int[] phy, int[] chem, int[] math, int N) {


        List<int[]> marks = new ArrayList<>();

        for(int i = 0; i < N; i++) {

            marks.add(new int[]{phy[i], chem[i], math[i]});
        }

        marks.sort((m1, m2) -> {

            if (m1[0] == m2[0] && m1[1] == m2[1]) {

                return m1[2] - m2[2];

            } else if (m1[0] == m2[0]) {

                return m2[1] - m1[1];

            } else {

                return m1[0] - m2[0];
            }

        });

        for(int i = 0; i < N; i++) {

            int[] mark = marks.get(i);

            phy[i] = mark[0];
            chem[i] = mark[1];
            math[i] = mark[2];

        }

    }
}
