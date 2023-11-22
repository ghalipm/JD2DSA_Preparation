package RecursivePractice;


//https://www.johndcook.com/blog/2018/03/24/squared-digit-sum/

// 1--> digits: 1; square of digits: 1; sum: 1; so 1 is perfect number.

// 2--> digits: 2; square of digits: 4; sum: 4; square digits sum (sds) is 4.
//4-->4^2=16-->1+36=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 2 is not perfect number: it circles in {4, 16, 37, 58, 89, 145, 42, 20, 4}.

// 3--> digits: 3; square of digits: 9; sds: 9;
//3-->9-->9^2=81-->64+1=65-->36+25=61-->36+1=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 3 is not perfect number: it circles in {9, 81, 65, 61, 37, 58, 89, 145, 42, 20, 4}.

// 4--> digits: 4; square of digits: 16; sds: 37;
//4-->16-->1+36=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 4 is not perfect number: it circles in {16, 37, 58, 89, 145, 42, 20, 4}.

// 5--> digits: 5; square of digits: 25; sds: 29;
//5-->25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 5 is not perfect number: it circles in {25, 29, 85, 89, 145, 42, 20, 4}.

// 6--> digits: 6; square of digits: 36; sum: 45;
//6-->36-->9+36=45-->25+25=50-->25+0=25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 6 is not perfect number: it circles in {36, 45, 50, 25, 29, 85, 89, 145, 42, 20, 4}.

// 7--> digits: 7; square of digits: 49; sds: 97;
//7-->49-->16+81=97-->81+49=130-->1+9+0=10-->1+0=1
// so 7 is perfect number: it circles in {49, 97, 130, 10, 1}.

// 8--> digits: 8; sds: 64; sum: 52;
//8-->64-->36+16=52-->25+4=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 8 is not perfect number: it circles in {64, 52, 29, 85, 89, 145, 42, 20, 4}.

// 9--> digits: 9; sds: 81; sum: 65;
//9-->81-->64+1=65-->36+25=61-->36+1=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 9 is not perfect number: it circles in {81, 65, 61, 37, 58, 89, 145, 42, 20, 4}.

// 10--> digits: 1, 0; sds: 1, 0; sum: 1;

// 11--> digits: 1, 1; sds: 2; sum: 4;

// 12--> digits: 1, 2; sds: 5; sum: 25;
//12,21-->5-->25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 12 and 21 are not perfect number: it circles in {5, 29, 85, 89, 145, 42, 20, 4}.

// 13,31 --> digits: 1, 3; sds: 10; sum: 1;

// 14,41--> digits: 1, 4; sds: 17; sum: 50;
//14-->17-->1+49=50-->25+0=25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 14, 41 is not perfect number: it circles in {17, 50, 25, 29, 85, 89, 145, 42, 20, 4}.

// 15,51--> digits: 1, 5; sds: 26; sum: 40;
//15-->26-->4+36=40-->16+0=16-->1+36=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
// so 15,51 is not perfect number: it circles in {26, 40, 16, 37, 58, 89, 145, 42, 20, 4}.

// 16,61--> digits: 1, 6; sds: 37; sum: 58;
//16-->37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 17,71--> digits: 1, 7; sds: 50; sum: 65;
//17-->50-->25+0=25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4
    // so 17,71 is not perfect number: it circles in {50, 25, 29, 85, 89, 145, 42, 20, 4}.

// 18,81--> digits: 1, 8; sds: 65; sum: 73;
//18-->65-->36+25=61-->36+1=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 19,91--> digits: 1, 9; sds: 82; sum: 68;
//19-->82-->64+4=68-->36+64=100-->1+0+0=1

// 20--> digits: 2, 0; sds: 4; sum: 4;

// 21, 12--> digits: 2, 1; sds: 5; sum: 25;
//21-->5-->25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 22--> digits: 2, 2; sds: 8; sum: 64;
//22-->8-->64-->36+16=52-->25+4=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 23--> digits: 2, 3; sds: 13; sum: 169;
//23-->13-->1+9=10-->1+0=1

// 24,42--> digits: 2, 4; sds: 20; sum: 25;
//24-->20-->4+0=4

// 25,52--> digits: 2, 5; sds: 29; sum: 85;
//25-->29-->85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 26,62--> digits: 2, 6; sds: 40; sum: 52;
//26-->40-->16+0=16-->1+36=37-->9+49=58-->25+64=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 27,72--> digits: 2, 7; sds: 53; sum: 58;
//27-->53-->25+9=34-->9+16=25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 28,82--> digits: 2, 8; sds: 68; sum: 100;
//28-->68-->100-->1+0+0=1

// 29,92--> digits: 2, 9; sds: 85; sum: 89;
//29-->85-->89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

// 30--> digits: 3, 0; sds: 9; sum: 9;

// 31,13--> digits: 3, 1; sds: 10; sum: 1;

// 32--> digits: 3, 2; sds: 13;

// 33--> digits: 3, 3; sds: 18;

// 34--> digits: 3, 4; sds: 25;

// 35--> digits: 3, 5; sds: 34;

// 36,63--> digits: 3, 6; sds: 45;
    //36-->45-->50-->25+0=25-->4+25=29-->4+81=85-->64+25=89-->64+81=145-->1+16+25=42-->16+4=20-->4+0=4

/**
 * So the above cases show that sds eventually either circles in {1} or {4}.
 */

/**
 * 1. find the digits of the number
 * 2. sum the squares of the digits
 * 3. if the sum is 1, then it is a perfect square
 * 4. if the sum is 4, then it is not a perfect square
 * 5. if the sum is not 1 or 4, then repeat the process until you hit either 1 or 4.
 */

public class PerfectNumber {
    public static int squareOfDigits(int number) {
        int digitSum = 0;
        if (number == 0) {
            return 0;
        }
        while (number != 0) {
            int digit = number % 10;
            digitSum += digit * digit;
            number /= 10;
        }
        return digitSum;
    }

    public static boolean isPerfect(int number) {
        System.out.println("number before loop = " + number);
        while (number != 0) {
            number = squareOfDigits(number);
            if (number == 1) {
                return true;
            } else if (number == 4) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Is perfect = " + isPerfect(13));
    }
}
