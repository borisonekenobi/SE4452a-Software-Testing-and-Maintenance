# Assignment 2

## Part A

### Question 1

#### (a)

L violates completeness because it does not account for arrays of length 3. For example, the array `[5, 8, 12]` is not
covered by L1, L2, or L3. H violates disjointness because arrays where all values are greater than 10 are covered by
both H2 and H3. For example, the array `[11, 15, 20]` is covered by H2 and H3.

#### (b)

We can modify L3 to account for arrays of length 3, allowing it to cover arrays of length greater than or equal to 3.
This would allow L to cover all non-null arrays, regardless of length, and fix the completeness violation. We can also
modify H2 to cover some, but not all, entries greater than 10. This would allow H to cover arrays where no values are
greater than 10, some but not all values are greater than 10, and all values are greater than 10, and fix the
disjointness violation by making the blocks mutually exclusive.

| Proposed Block                                 | Representative Array |
|------------------------------------------------|----------------------|
| L1: length 0                                   | `[]`                 |
| L2: length 1 or 2                              | `[5]`                |
| L3: length greater than or equal to 3          | `[5, 8, 12]`,        |
| H1: no entries greater than 10                 | `[5, 8, 9]`          |
| H2: some, but not all, entries greater than 10 | `[5, 8, 12]`         |
| H3: all entries greater than 10                | `[11, 15, 20]`       |

#### (c)

`null` would be an invalid input that `countHigh(readings)` should reject with an `IllegalArgumentException`. Passing an
array of length 2 and a high-reading count greater than 2 is impossible, since the maximum number of high readings in an
array of length 2 is 2. The first test case can be tested because `null` is a value you can supply as an argument to the
function. The second test case cannot be tested because it is impossible to have an array of length 2 with a
high-reading count greater than 2.
