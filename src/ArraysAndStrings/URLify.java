package ArraysAndStrings;

public class URLify {
    public static void solve(char arr[], int length) {
        // maintain 2 pointers
        // pointer 1: starts at the back of the char arr. Pointer for characters to be moved to.
        // pointer 2: starts at the last non space character. Pointer for characters to be moved from.
        // use a first for loop to set the location of both pointers correctly
        // use a second for loop for length time. this second loop is where the main logic happens
        // second loop:
        // shift character from first to second pointer
        // first pointer--, second pointer--
        // if encounter space, then add 0 2 % and move second pointer by 3 positions to the left, first pointer only
        // moves left by one position
        // if first pointer and second pointer are at the same position, terminate
        int pointerOne = length - 1;
        int pointerTwo = arr.length - 1;

        for (int i = 0; i < length; i++) {
            if (pointerOne == pointerTwo) {
                break;
            }
            if (arr[pointerOne] == ' ') {
                arr[pointerTwo] = '0';
                arr[pointerTwo - 1] = '2';
                arr[pointerTwo - 2] = '%';
                pointerOne--;
                pointerTwo -= 3;
            } else {
                arr[pointerTwo] = arr[pointerOne];
                pointerOne--;
                pointerTwo--;
            }
        }
    }
}

// Time complexity: O(N), length of char array
// Space complexity: O(1)

// oact cat