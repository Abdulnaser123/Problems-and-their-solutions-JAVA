/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageClient {

    public static void main(String[] args) {
        int arr[] = {1, 10, 20, 200, 30, 50, 60, 60, 80, 110, 130, 140, 170};
        int arr1[] = new int[]{1, 2, 3, 3, 4, 5, 7};
//        List <Integer> common = findCommonElementsInThreeArrays(new int[]{1,2,3,4}, new int[]{3,4,5,6}, new int[]{4,5,6,9});
//        for (Integer integer : common) {
//            System.out.println(integer);
//        }
//        insertIntoSortedArray(arr, 4, 121);
//                printArray(arr);

//        deleteFromArray(arr, 2);
//        printArray(arr);
//        twoNumberHasClosestSumToZero(arr);
//      System.out.println(findMissingNumber(arr1));
        //System.out.println(firstRepeatingNumer(arr));
//      binarySearch(arr, arr.length, 111);
//      largestThreeElements(new int[]{10, 4, 3, 50, 23, 90});
//        findAPairWithGivenDifference(arr, 20);
//        System.out.println(pivoteElement(new int[]{5, 1, 4, 3, 6, 8, 11, 10, 7, 9}));
//        largestSumOfTwoElement(new int[]{5, 1, 4, 3, 6, 8, 11, 10, 7, 9});
        findElementInSortedAndRotateArray(new int[]{30, 40, 50, 10, 20}, 10);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("");
    }

    public static void binarySearch(int arr[], int k) {
        int low = 0;
        int heigh = arr.length - 1;
        while (low <= heigh) {
            int middle = (heigh + low) / 2;
            if (arr[middle] == k) {
                System.out.println("found");
                return;
            } else if (arr[middle] > k) {
                heigh = middle - 1;
            } else if (arr[middle] < k) {
                low = middle + 1;
            } else {
                System.out.println("not found");
                return;
            }
        }

    }

    public static int largestThreeElements(int arr[]) {
        if (arr.length > 3) {
            for (int j = 0; j < 3; j++) {
                int largestOne = arr[j];
                int m = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > largestOne) {
                        largestOne = arr[i];
                        m = i;
                    }

                }
                System.out.println(largestOne);
                arr[m] = 0;
            }
        }
        return -1;
    }

    public static void largestThreeElements2(int arr[]) {
        if (arr.length > 3) {
            Arrays.sort(arr);
            for (int i = arr.length - 1; i > arr.length - 4; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public static int findMissingNumber(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1] - 1) {
                return arr[i + 1];
            }
        }
        return -1;
    }

    public static int firstRepeatingNumer(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[j];
                }
            }
        }
        return -1;
    }

    public static void insertIntoSortedArray(int arr[], int index, int value) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;

    }

    public static void deleteFromArray(int[] arr, int index) {
        try {
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = 0;

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void twoNumberHasClosestSumToZero(int arr[]) {
        int closestSumToZero = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int num1 = 0, num2 = 0;
        for (i = 0; i < arr.length - 1; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] < closestSumToZero) {
                    closestSumToZero = arr[i] + arr[j];
                }
                num1 = arr[i];
                num2 = arr[j];
            }
        }
        System.out.println("closest sum 2 number to zero is " + closestSumToZero + '=' + num1 + '+' + num2);
    }

    public static void findAPairWithGivenDifference(int[] arr, int n) {
        Arrays.sort(arr);
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = arr.length - 1; i >= 1; i--) {
                if (arr[i] - arr[j] == n) {
                    System.out.println(arr[i] + "  " + arr[j]);
                    return;
                }

            }
        }

    }

    public static List<Integer> findCommonElementsInThreeArrays(int arr1[], int arr2[], int arr3[]) {
        int i = 0, j = 0, k = 0;
        List<Integer> commonElements = new ArrayList<>();

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                commonElements.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else if (arr2[j] > arr3[k]) {
                k++;
            } else if (arr1[i] < arr3[k]) {
                i++;
            } else if (arr1[i] > arr3[k]) {
                k++;
            } else {
                break;
            }
        }
        return commonElements;
    }

    public static int pivoteElement(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int middle = (l + r) / 2;
            if (arr[middle] > arr[middle - 1] && arr[middle] < arr[middle + 1]) {
                return arr[middle];
            } else if (arr[middle] < arr[middle - 1]) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return -1;
    }

    public static void largestSumOfTwoElement(int arr[]) {
        int i = 0, j = 1;
        int largestSum = 0;

        for (int k = 2; k < arr.length; k++) {
            if (arr[i] > arr[j]) {
                if (arr[k] > arr[j]) {
                    j = k;
                }
            } else {
                if (arr[k] > arr[i]) {
                    i = k;
                }

            }
            largestSum = arr[i] + arr[j];

        }
        System.out.println(largestSum);
    }

    public static void findElementInSortedAndRotateArray(int[] arr, int k) {
        int middleIndex = 0;
        int f = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                middleIndex = i + 1;
                f = 1;

            }
            if (f == 1) {
                break;
            } else {
                continue;
            }
        }
        if (k >= arr[0] && k <= arr[middleIndex - 1]) {
            int[] copyArray = copyRange(arr, 0, middleIndex - 1);
            binarySearch(copyArray, k);

        } else if (k >= arr[middleIndex] && k <= arr[arr.length - 1]) {
            int[] copyArray = copyRange(arr, middleIndex , arr.length - 1);
            binarySearch(copyArray, k);
        } else {
            System.out.println("not found");
        }
    }

    public static int[] copyRange(int[] originalArray, int startIndex, int endIndex) {
        int length = endIndex - startIndex + 1;
        int[] copiedArray = new int[length];
        for (int i = 0; i < length; i++) {
            copiedArray[i] = originalArray[startIndex + i];
        }
        return copiedArray;
    }
}
