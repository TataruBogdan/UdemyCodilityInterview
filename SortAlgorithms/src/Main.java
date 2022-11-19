
/* stable versus unstable comes into play when you have duplicate values in the data that you're sorting.
* [5, 9, 3, 9, 8, 4]
* array - it contains two nines. There is a nine at position one and there's a nine at position three.
* question - when we sort this array, will the original ordering of the two nines be preserved?
* In other words, in the sorted array, will the white nine still come before the black nine or will their positions have changed?
* so that the black nine comes before the white nine?
* If a sort is unstable, then that means the relative ordering of duplicate items will not be preserved.
* And so in an unstable sort, the black nine will end up coming before the white nine. the two nines have flipped position.
* A stable sort, after we've sorted, the white nine still appears before the black nine, so the relative ordering
* of the duplicate items has been preserved and in this case it's a stable sort.
* a stable sort is preferable to an unstable sort.
* If you're sorting objects, it could make a difference depending on how you're using it.
* If you wanna do a sort within a sort, so for example you may first sort based on name and then you wanna sort
* based on age or something, well if the second sort causes the positions you got from the first sort to flip,
* that's going to be a problem. you're not going to want a sort to change the ordering of duplicate items.
* */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}