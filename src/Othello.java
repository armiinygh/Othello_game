/*
Project By Alireza Amini And Seyed Alireza Yaghoubi
For More InFormation Contact Us
Phone Number: +989912044067
Email: aminialireza936@gmail.com

*/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;


class Place {
    int x;
    int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class HeapSort {

    public void sort(ArrayList<TreeNode> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            TreeNode temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0);
        }
    }

    void heapify(ArrayList<TreeNode> arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr.get(l).fit > arr.get(largest).fit)
            largest = l;
        if (r < n && arr.get(r).fit > arr.get(largest).fit)
            largest = r;
        if (largest != i) {
            TreeNode swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            heapify(arr, n, largest);
        }
    }
}

class HeapSortForFour {

    public void sort(Vector<fourPair> arr) {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            fourPair temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            heapify(arr, i, 0);
        }
    }

    void heapify(Vector<fourPair> arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr.get(l).score < arr.get(largest).score)
            largest = l;
        if (r < n && arr.get(r).score < arr.get(largest).score)
            largest = r;
        if (largest != i) {
            fourPair swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);
            heapify(arr, n, largest);
        }
    }
}

class threePair{
    double first;
    double second;
    double third;

    public threePair(double first, double second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class fourPair{
    threePair tp;
    int score;

    public fourPair(threePair tp) {
        this.tp = tp;
        this.score = 0;
    }

    public fourPair(threePair tp, int score) {
        this.tp = tp;
        this.score = score;
    }
}

class Tree{
    TreeNode parent;

    public Tree(threePair tp) {
        int [][] mat = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mat[i][j] = 0;
            }
        }
        mat[3][3] = 1;
        mat[4][4] = 1;
        mat[3][4] = -1;
        mat[4][3] = -1;
        this.parent = new TreeNode(mat, null);
        calculateFit(parent, tp, false);
    }

    public Tree(int[][] mat) {
        this.parent = new TreeNode(mat, null);
    }

    private int[][] fillMat(int[][] mat, int x, int y, boolean turn){
        for (int i = 0 ; i < 8 ;i++){
            for (int j = 0; j < 8; j++){
                if (mat[i][j] == 2)
                    mat[i][j] = 0;
            }
        }
        int i = x;
        int j = y;
        if (turn){
            mat[i][j] = 1;
            while (i-1 >= 0){
                if (mat[i-1][j] == -1)
                    mat[i-1][j] = 1;
                else
                    break;
                i--;
            }
            i = x;
            while (i+1 < 8){
                if (mat[i+1][j] == -1)
                    mat[i+1][j] = 1;
                else
                    break;
                i++;
            }
            i = x;
            while (j-1 >= 0){
                if (mat[i][j-1] == -1)
                    mat[i][j-1] = 1;
                else
                    break;
                j--;
            }
            j = y;
            while (j+1 < 8){
                if (mat[i][j+1] == -1)
                    mat[i][j+1] = 1;
                else
                    break;
                j++;
            }
            j = y;
            while (i-1 >= 0 && j-1 >= 0){
                if (mat[i-1][j-1] == -1)
                    mat[i-1][j-1] = 1;
                else
                    break;
                j--;
                i--;
            }
            j = y;
            i = x;
            while (i+1 < 8 && j-1 >= 0){
                if (mat[i+1][j-1] == -1)
                    mat[i+1][j-1] = 1;
                else
                    break;
                j--;
                i++;
            }
            j = y;
            i = x;
            while (i-1 >= 0 && j+1 < 8){
                if (mat[i-1][j+1] == -1)
                    mat[i-1][j+1] = 1;
                else
                    break;
                j++;
                i--;
            }
            j = y;
            i = x;
            while (i+1 < 8 && j+1 < 8){
                if (mat[i+1][j+1] == -1)
                    mat[i+1][j+1] = 1;
                else
                    break;
                j++;
                i++;
            }
            j = y;
            i = x;
        }else{
            mat[i][j] = -1;
            while (i-1 >= 0){
                if (mat[i-1][j] == 1)
                    mat[i-1][j] = -1;
                else
                    break;
                i--;
            }
            i = x;
            while (i+1 < 8){
                if (mat[i+1][j] == 1)
                    mat[i+1][j] = -1;
                else
                    break;
                i++;
            }
            i = x;
            while (j-1 >= 0){
                if (mat[i][j-1] == 1)
                    mat[i][j-1] = -1;
                else
                    break;
                j--;
            }
            j = y;
            while (j+1 < 8){
                if (mat[i][j+1] == 1)
                    mat[i][j+1] = -1;
                else
                    break;
                j++;
            }
            j = y;
            while (i-1 >= 0 && j-1 >= 0){
                if (mat[i-1][j-1] == 1)
                    mat[i-1][j-1] = -1;
                else
                    break;
                j--;
                i--;
            }
            j = y;
            i = x;
            while (i+1 < 8 && j-1 >= 0){
                if (mat[i+1][j-1] == 1)
                    mat[i+1][j-1] = -1;
                else
                    break;
                j--;
                i++;
            }
            j = y;
            i = x;
            while (i-1 >= 0 && j+1 < 8){
                if (mat[i-1][j+1] == 1)
                    mat[i-1][j+1] = -1;
                else
                    break;
                j++;
                i--;
            }
            j = y;
            i = x;
            while (i+1 < 8 && j+1 < 8){
                if (mat[i+1][j+1] == 1)
                    mat[i+1][j+1] = -1;
                else
                    break;
                j++;
                i++;
            }
            j = y;
            i = x;
        }
        return mat;
    }

    private void copyMat(int[][] firstMat, int[][] secondMat){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                switch (secondMat[i][j]){
                    case -1:
                        firstMat[i][j] = -1;
                        break;
                    case 0:
                        firstMat[i][j] = 0;
                        break;
                    case 1:
                        firstMat[i][j] = 1;
                        break;
                    case 2:
                        firstMat[i][j] = 2;
                        break;
                    default:
                        System.out.println("fuck");
                        break;
                }
            }
        }
    }

    private void calculateFit(TreeNode treeNode, threePair tp, boolean turn){
        treeNode.fit = tp.first*calculateScore(treeNode.nodeMat, turn) + tp.second*calculateDistEdge(treeNode, turn) + tp.third*calculateZeroHouses(treeNode.nodeMat, turn);
    }

    private ArrayList<TreeNode> reverseArrayList(ArrayList<TreeNode> alist) {
        ArrayList<TreeNode> revArrayList = new ArrayList<TreeNode>();
        for (int i = alist.size() - 1; i >= 0; i--) {
            revArrayList.add(alist.get(i));
        }
        return revArrayList;
    }

    private ArrayList<TreeNode> makeChildNodes(int[][] mat, boolean turn, threePair tp){
        ArrayList<TreeNode> childs = new ArrayList<>();
        TreeNode addNew;
        int[][] temp = new int[8][8];
        for (int i = 0; i < 8 ; i++){
            for (int j = 0; j < 8 ; j++){
                if (mat[i][j] == 2){
                    copyMat(temp, mat);
                    fillMat(temp, i, j, turn);
                    addNew = new TreeNode(temp, null);
                    calculateFit(addNew, tp, !turn);
                    childs.add(addNew);
                }
            }
        }
        HeapSort heapSort = new HeapSort();
        heapSort.sort(childs);
        if (turn)
            childs = reverseArrayList(childs);
        return childs;
    }

    private int newGuid(TreeNode treeNode, boolean turn){
        int sum = 0;
        for (int i1 = 0 ; i1 < 8 ; i1++) {
            for (int j1 = 0; j1 < 8; j1++) {
                if (treeNode.nodeMat[i1][j1] == 2)
                    treeNode.nodeMat[i1][j1] = 0;
            }
        }
        for (int i = 0; i < 8 ; i ++){
            for (int j = 0; j < 8 ; j++){
                boolean visitAtLeastOne = false;
                if (!turn){
                    if (treeNode.nodeMat[i][j] == -1){
                        int i1 = i;
                        int j1 = j;
                        while (i1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 - 1][j] != 1) {
                                    if (treeNode.nodeMat[i1 - 1][j] == 0) {
                                        treeNode.nodeMat[i1 - 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (i1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 + 1][j] != 1) {
                                    if (treeNode.nodeMat[i1 + 1][j] == 0) {
                                        treeNode.nodeMat[i1 + 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (j1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] != 1) {
                                    if (treeNode.nodeMat[i][j1-1] == 0) {
                                        treeNode.nodeMat[i][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1--;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (j1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] != 1) {
                                    if (treeNode.nodeMat[i][j1+1] == 0){
                                        treeNode.nodeMat[i][j1+1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1++;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (i1-1>=0 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] != 1) {
                                    if (treeNode.nodeMat[i1-1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] != 1) {
                                    if (treeNode.nodeMat[i1+1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1-1 >= 0 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] != 1) {
                                    if (treeNode.nodeMat[i1-1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] != 1) {
                                    if (treeNode.nodeMat[i1+1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                    }
                }else{
                    if (treeNode.nodeMat[i][j] == 1){
                        int i1 = i;
                        int j1 = j;
                        while (i1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 - 1][j] != -1) {
                                    if (treeNode.nodeMat[i1 - 1][j] == 0) {
                                        treeNode.nodeMat[i1 - 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (i1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 + 1][j] != -1) {
                                    if (treeNode.nodeMat[i1 + 1][j] == 0) {
                                        treeNode.nodeMat[i1 + 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (j1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] != -1) {
                                    if (treeNode.nodeMat[i][j1-1] == 0) {
                                        treeNode.nodeMat[i][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1--;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (j1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] != -1) {
                                    if (treeNode.nodeMat[i][j1+1] == 0) {
                                        treeNode.nodeMat[i][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1++;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (i1-1>=0 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] != -1) {
                                    if (treeNode.nodeMat[i1-1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] != -1) {
                                    if (treeNode.nodeMat[i1+1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1-1 >= 0 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] != -1) {
                                    if (treeNode.nodeMat[i1-1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] != -1) {
                                    if (treeNode.nodeMat[i1+1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                    }
                }
            }
        }
        return sum;
    }

    private int calculateScore(int[][] mat, boolean turn){
        int sum = 0;
        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0; j < 8 ; j++){
                if (turn){
                    if (mat[i][j] == 1)
                        sum += mat[i][j];
                }else {
                    if (mat[i][j] == -1)
                        sum += mat[i][j];
                }

            }
        }
        return sum;
    }

    private int calculateZeroHouses(int[][] mat, boolean turn){
        int sum = 0;
        for (int i = 0 ; i < 8 ; i ++){
            for (int j = 0 ; j < 8 ; j++){
                if (mat[i][j] == 0 || mat[i][j] == 2)
                    sum++;
            }
        }
        if (turn)
            return sum;
        else
            return (0 - sum);
    }

    private double calculateDistEdge(TreeNode current, boolean turn){
        double fin = Double.MAX_VALUE;
        double temp1 = Math.sqrt(Math.pow(current.changed.x, 2)+Math.pow(current.changed.y, 2));
        double temp2 = Math.sqrt(Math.pow(current.changed.x - 7, 2)+Math.pow(current.changed.y, 2));
        double temp3 = Math.sqrt(Math.pow(current.changed.x, 2)+Math.pow(current.changed.y-7, 2));
        double temp4 = Math.sqrt(Math.pow(current.changed.x-7, 2)+Math.pow(current.changed.y-7, 2));
        if (fin > temp1)
            fin = temp1;
        if (fin > temp2)
            fin = temp2;
        if (fin > temp3)
            fin = temp3;
        if (fin > temp4)
            fin = temp4;
        if (turn)
            return fin;
        else
            return (0 - fin);
    }

    private void checkP(TreeNode treeNode){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (treeNode.nodeMat[i][j] >= 0)
                    System.out.print(treeNode.nodeMat[i][j] + "   ");
                else
                    System.out.print(treeNode.nodeMat[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public double fillTree(TreeNode mNode, int depth, int alpha, int beta, boolean turn, threePair blackTP, threePair whiteTP) {
        if (depth == 0 || mNode.gameOver) {
            mNode.score = calculateScore(mNode.nodeMat, turn);
            mNode.distEdge = calculateDistEdge(mNode, turn);
            mNode.zeroHouses = calculateZeroHouses(mNode.nodeMat, turn);
            if (turn)
                mNode.fit = whiteTP.first*mNode.score + whiteTP.second*mNode.distEdge + whiteTP.third*mNode.zeroHouses;
            else
                mNode.fit = blackTP.first*mNode.score + blackTP.second*mNode.distEdge + blackTP.third*mNode.zeroHouses;
            return mNode.fit;
        }
        if (turn) {
            int maxEval = Integer.MIN_VALUE;
            if (newGuid(mNode, true) != 0){
                mNode.child = makeChildNodes(mNode.nodeMat, true, blackTP);
                for (int i = 0; i < mNode.child.size(); i++) {
                    mNode.child.get(i).parent = mNode;
                }
            } else {
                mNode.child = mNode.parent.child;
                mNode.changed = mNode.parent.changed;
                mNode.nodeMat = mNode.parent.nodeMat;
                mNode.score = mNode.parent.score;
                mNode.parent = mNode.parent.parent;
            }
            for (int i = 0; i < mNode.child.size(); i++) {
                double eval = fillTree(mNode.child.get(i), depth - 1, alpha, beta, false, blackTP, whiteTP);
                maxEval = Integer.max(maxEval, (int)eval);
                alpha = Integer.max(alpha, (int)eval);
                if (beta <= alpha)
                    break;
            }
            mNode.fit = maxEval;
            return maxEval;
        }else {
            int minEval = Integer.MAX_VALUE;
            if (newGuid(mNode, false) != 0){
                mNode.child = makeChildNodes(mNode.nodeMat, false, whiteTP);
                for (int i = 0; i < mNode.child.size(); i++) {
                    mNode.child.get(i).parent = mNode;
                }
            } else {
                mNode.child = mNode.parent.child;
                mNode.changed = mNode.parent.changed;
                mNode.nodeMat = mNode.parent.nodeMat;
                mNode.score = mNode.parent.score;
                mNode.parent = mNode.parent.parent;
            }
            for (int i = 0; i < mNode.child.size() ; i++){
                double eval = fillTree(mNode.child.get(i), depth-1, alpha, beta, true, blackTP, whiteTP);
                minEval = Integer.min(minEval, (int)eval);
                beta = Integer.min(beta, (int)eval);
                if (beta <= alpha)
                    break;
            }
            mNode.fit = minEval;
            return minEval;
        }
    }
}

class TreeNode{
    int[][] nodeMat;
    int score;
    double fit;
    double distEdge;
    int zeroHouses;
    boolean checked;
    boolean gameOver;
    Place changed;
    TreeNode parent;
    ArrayList<TreeNode> child;

    public TreeNode(int[][] nodeMat, TreeNode parent) {
        this.nodeMat = nodeMat;
        this.score = 0;
        this.distEdge = Double.MAX_VALUE;
        this.fit = 0;
        this.zeroHouses = 64;
        this.checked = false;
        this.gameOver = false;
        this.parent = parent;
        this.child = new ArrayList<>();
        this.changed = new Place(0,0);
    }

}

class PlayGame {
    boolean endGame = false;
    double finalScoreForFit = 0;
    int countOfWinner = 0;
    int winner = 0;
    private final int MAXInt = Integer.MAX_VALUE;
    private final int MINInt = Integer.MIN_VALUE;
    private TreeNode current;
    private int treeLvl = 0;
    Tree tree;
    LiveScore liveScore;

    PlayGame(threePair blackTP, threePair whiteTP) {
        this.tree = new Tree(blackTP);
        tree.fillTree(tree.parent, 6, MINInt, MAXInt, false, blackTP, whiteTP);
        current = tree.parent;
    }

    private void printMat(TreeNode t1) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (t1.nodeMat[i][j] >= 0)
                    System.out.print(t1.nodeMat[i][j] + "   ");
                else
                    System.out.print(t1.nodeMat[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public void newMove(threePair blackTp, threePair whiteTp) {
        if (treeLvl > 4) {
            Tree tree1 = new Tree(current.parent.nodeMat);
            tree1.parent.score = current.parent.score;
            tree1.fillTree(tree1.parent, 6, MINInt, MAXInt, false, blackTp, whiteTp);
            current = tree1.parent;
            treeLvl = 0;
        }
        newGuid(current, false);
        printMat(current);
        System.out.println("========================");
        treeLvl++;
        current = current.child.get(0);
        if (endGameState(current.nodeMat))
            return;
        newGuid(current, true);
        printMat(current);
        System.out.println("--------------------------");
        treeLvl++;
        current = current.child.get(0);
        if (endGameState(current.nodeMat))
            return;

    }

    private boolean endGameState(int[][] mat) {
        boolean state = true;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (mat[i][j] == 0 || mat[i][j] == 2)
                    state = false;
            }
        }
        if (state){
            endGame = true;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (mat[i][j] >= 0)
                        System.out.print(mat[i][j] + "   ");
                    else
                        System.out.print(mat[i][j] + "  ");
                }
                System.out.println();
            }
            for (int i = 0; i < 8 ; i++){
                for (int j = 0 ; j < 8 ; j++){
                    finalScoreForFit += mat[i][j];
                }
            }
            if (finalScoreForFit > 0){
                System.out.println("winner is white");
                for (int m = 0 ; m < 8 ; m++){
                    for (int n = 0 ; n < 8 ; n++){
                        if (mat[m][n] == 1)
                            countOfWinner ++;
                    }
                }
                winner = 1;
            }else if (finalScoreForFit < 0){
                System.out.println("winner is black");
                for (int m = 0 ; m < 8 ; m++){
                    for (int n = 0 ; n < 8 ; n++){
                        if (mat[m][n] == -1)
                            countOfWinner ++;
                    }
                }
                winner = -1;
            }else {
                System.out.println("it's draw");
                winner = 0;
            }
            System.out.println("Game Over");
        }
        return state;
    }

    private int newGuid(TreeNode treeNode, boolean turn){
        int sum = 0;
        for (int i1 = 0 ; i1 < 8 ; i1++) {
            for (int j1 = 0; j1 < 8; j1++) {
                if (treeNode.nodeMat[i1][j1] == 2)
                    treeNode.nodeMat[i1][j1] = 0;
            }
        }
        for (int i = 0; i < 8 ; i ++){
            for (int j = 0; j < 8 ; j++){
                boolean visitAtLeastOne = false;
                if (!turn){
                    if (treeNode.nodeMat[i][j] == -1){
                        int i1 = i;
                        int j1 = j;
                        while (i1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 - 1][j] != 1) {
                                    if (treeNode.nodeMat[i1 - 1][j] == 0) {
                                        treeNode.nodeMat[i1 - 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (i1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 + 1][j] != 1) {
                                    if (treeNode.nodeMat[i1 + 1][j] == 0) {
                                        treeNode.nodeMat[i1 + 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (j1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] != 1) {
                                    if (treeNode.nodeMat[i][j1-1] == 0) {
                                        treeNode.nodeMat[i][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1--;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (j1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] != 1) {
                                    if (treeNode.nodeMat[i][j1+1] == 0){
                                        treeNode.nodeMat[i][j1+1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1++;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (i1-1>=0 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] != 1) {
                                    if (treeNode.nodeMat[i1-1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] != 1) {
                                    if (treeNode.nodeMat[i1+1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1-1 >= 0 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] != 1) {
                                    if (treeNode.nodeMat[i1-1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] == 1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] != 1) {
                                    if (treeNode.nodeMat[i1+1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                    }
                }else{
                    if (treeNode.nodeMat[i][j] == 1){
                        int i1 = i;
                        int j1 = j;
                        while (i1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 - 1][j] != -1) {
                                    if (treeNode.nodeMat[i1 - 1][j] == 0) {
                                        treeNode.nodeMat[i1 - 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (i1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1 + 1][j] != -1) {
                                    if (treeNode.nodeMat[i1 + 1][j] == 0) {
                                        treeNode.nodeMat[i1 + 1][j] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        while (j1-1 >= 0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1-1] != -1) {
                                    if (treeNode.nodeMat[i][j1-1] == 0) {
                                        treeNode.nodeMat[i][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1--;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (j1+1 < 8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i][j1+1] != -1) {
                                    if (treeNode.nodeMat[i][j1+1] == 0) {
                                        treeNode.nodeMat[i][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            j1++;
                        }
                        visitAtLeastOne = false;
                        j1 = j;
                        while (i1-1>=0 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1-1] != -1) {
                                    if (treeNode.nodeMat[i1-1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1-1>=0){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1-1] != -1) {
                                    if (treeNode.nodeMat[i1+1][j1-1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 - 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1--;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1-1 >= 0 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1-1][j1+1] != -1) {
                                    if (treeNode.nodeMat[i1-1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 - 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1--;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                        while (i1+1 < 8 && j1+1 <8){
                            if (!visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] == -1){
                                    visitAtLeastOne = true;
                                }else
                                    break;
                            }
                            if (visitAtLeastOne) {
                                if (treeNode.nodeMat[i1+1][j1+1] != -1) {
                                    if (treeNode.nodeMat[i1+1][j1+1] == 0) {
                                        treeNode.nodeMat[i1 + 1][j1 + 1] = 2;
                                        sum++;
                                    }
                                    break;
                                }
                            }
                            i1++;
                            j1++;
                        }
                        visitAtLeastOne = false;
                        i1 = i;
                        j1 = j;
                    }
                }
            }
        }
        return sum;
    }
}

class LiveScore extends JFrame{

    JPanel jp = new JPanel(new GridLayout(64, 3, 1, 1));
    JLabel[][] score = new JLabel[62][3];

    LiveScore() {
        super("Live Scores");
        setSize(200, 800);
        setLocation(1000, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(jp);
        jp.setBackground(Color.gray);
        score[0][0] = new JLabel("LEVEL", SwingConstants.CENTER);
        score[0][1] = new JLabel("WHITE", SwingConstants.CENTER);
        score[0][2] = new JLabel("BLACK", SwingConstants.CENTER);
        score[1][0] = new JLabel("0", SwingConstants.CENTER);
        score[1][1] = new JLabel("2", SwingConstants.CENTER);
        score[1][2] = new JLabel("2", SwingConstants.CENTER);
        for (int i = 2; i < 62; i++) {
            score[i][0] = new JLabel("" + (i - 1), SwingConstants.CENTER);
            score[i][1] = new JLabel("", SwingConstants.CENTER);
            score[i][2] = new JLabel("", SwingConstants.CENTER);
        }
        for (int i = 0; i < 62; i++) {
            for (int j = 0; j < 3; j++) {
                score[i][j].setOpaque(true);
                score[i][j].setBackground(Color.white);
                jp.add(score[i][j]);
            }
        }
        setVisible(true);
    }

    void newItem() {
        setVisible(false);
    }

    void setScore(int level, boolean white, int value) {
        score[level + 1][white ? 1 : 2].setText(value + "");
    }
}

public class Othello {

    private static fourPair crossOver(fourPair firstPar,fourPair secondPar){
        double firstRand = Math.random();
        double secondRand = Math.random();
        double thirdRand = Math.random();
        threePair tp = new threePair(firstPar.tp.first * firstRand + secondPar.tp.first * firstRand, firstPar.tp.second * secondRand + secondPar.tp.second * secondRand, firstPar.tp.third * thirdRand + secondPar.tp.third * thirdRand);
        return new fourPair(tp);
    }

    private static void mutation (fourPair fp){
        int firstIndex = (int)(Math.random() * (3));
        int secondIndex = (int)(Math.random() * (3));
        double temp;
        if (firstIndex != secondIndex){
            switch (firstIndex){
                case 0:
                    if (secondIndex == 1){
                        temp = fp.tp.first;
                        fp.tp.first = fp.tp.second;
                        fp.tp.second = temp;
                    }else if (secondIndex == 2){
                        temp = fp.tp.first;
                        fp.tp.first = fp.tp.third;
                        fp.tp.third = temp;
                    }
                    break;
                case 1:
                    if (secondIndex == 0){
                        temp = fp.tp.second;
                        fp.tp.second = fp.tp.first;
                        fp.tp.first = temp;
                    }else if (secondIndex == 2){
                        temp = fp.tp.second;
                        fp.tp.second = fp.tp.third;
                        fp.tp.third = temp;
                    }
                    break;
                case 2:
                    if (secondIndex == 0){
                        temp = fp.tp.third;
                        fp.tp.third = fp.tp.first;
                        fp.tp.first = temp;
                    }else if (secondIndex == 1){
                        temp = fp.tp.third;
                        fp.tp.third = fp.tp.second;
                        fp.tp.second = temp;
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        PlayGame playGame;
        HeapSortForFour heapSortForFour;
        heapSortForFour = new HeapSortForFour();
        Vector<fourPair> population = new Vector<>();
        Vector<fourPair> tempPopulation = new Vector<>();
        fourPair fp;
        threePair tp;
        for (int i=0; i < 100 ; i++){
            double a,b,c;
            a = Math.random();
            b = Math.random();
            c = Math.random();
            tp = new threePair(a, b, c);
            fp = new fourPair(tp);
            population.add(fp);
        }
        int i = 0;
        int firstParentIndex = 0;
        int secondParentIndex = 0;
        int populationSize = 0;
        int blackPlayer = 0;
        int whitePlayer = 0;

        threePair blackTP;
        threePair whiteTP;
        double superParameterForImpregnation = 0.5;
        double superParameterForMutation = 0.4;
        fourPair firstPar;
        fourPair secondPar;
        while (i < 100 && population.size() > 1 && population.get(0).score < 50){
            populationSize = population.size();
            for (int j = 0; j < populationSize/2 ; j++){
                firstParentIndex = j;
                secondParentIndex = populationSize/2 + j;
                firstPar = population.get(firstParentIndex);
                secondPar = population. get(secondParentIndex);
                if (Math.random() < superParameterForImpregnation) {
                    population.add(crossOver(firstPar, secondPar));
                    //population.remove(firstParentIndex);
                    //population.remove(secondParentIndex);
                    if (Math.random() < superParameterForMutation){
                        mutation(population.get(population.size()-1));
                    }
                }/*else {
                    population.remove(firstParentIndex);
                    population.remove(secondParentIndex);
                }*/
            }
            heapSortForFour.sort(population);
            if (population.size()%2 !=0 && population.size()>1)
                population.remove(population.size()-1);
            populationSize = population.size();
            if (populationSize > 1){
                for (int  x = 0; x < populationSize; x++){
                    tempPopulation.add(population.get(x));
                }
                for (int j = 0 ; j < populationSize/2 ; j++){
                    blackPlayer = j;
                    whitePlayer = j+ populationSize/2;
                    blackTP = population.get(blackPlayer).tp;
                    whiteTP = population.get(whitePlayer).tp;
                    playGame = new PlayGame(blackTP, whiteTP);
                    for (int k = 0 ; k < 62 ; k++){
                        playGame.newMove(blackTP, whiteTP);
                        if (playGame.endGame){
                            if (playGame.winner == 0){

                            }else if (playGame.winner == -1){
                                fourPair newState = new fourPair(blackTP, playGame.countOfWinner);
                                tempPopulation.add(newState);
                            }else if (playGame.winner == 1){
                                fourPair newState = new fourPair(whiteTP, playGame.countOfWinner);
                                tempPopulation.add(newState);
                            }
                            break;
                        }
                    }
                }
                population = new Vector<>(tempPopulation);
                heapSortForFour.sort(population);
            }
            if (population.size()%2 !=0 && population.size()>1)
                population.remove(population.size()-1);
            else if (population.size() == 1)
                break;
            i++;
        }
        System.out.println("Best Heuristic Value Is : \n a: "+ population.get(0).tp.first +"\n b: "+population.get(0).tp.second+"\n c: "+population.get(0).tp.third);

    }
}