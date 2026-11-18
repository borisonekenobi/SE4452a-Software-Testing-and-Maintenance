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

### Question 2

#### (a)

There are $3 \times 3 \times 2 = 18$ full block tuples before applying constraints. Below is a list of every infeasible
full tuple.

| Tuple        | Justification                                                                                                         |
|--------------|-----------------------------------------------------------------------------------------------------------------------|
| (A1, B2, C2) | It is impossible to have an array of length 1 with a high-reading count =1, when there is at least one negative entry |
| (A1, B3, C1) | It is impossible to have an array of length 1 with a high-reading count ≥2                                            |
| (A1, B3, C2) | It is impossible to have an array of length 1 with a high-reading count ≥2                                            |
| (A2, B3, C2) | It is impossible to have an array of length 2 with a high-reading count ≥2, when there is at least one negative entry |

ACoC requires $18 - 4 = 14$ feasible full tuples.

#### (b)

Suite:

| ID  | Tuple        | Concrete Array     | Expected Return Value |
|:---:|--------------|--------------------|:---------------------:|
| 112 | (A1, B1, C2) | `[-5]`             |           0           |
| 121 | (A1, B2, C1) | `[15]`             |           1           |
| 211 | (A2, B1, C1) | `[5, 8]`           |           0           |
| 222 | (A2, B2, C2) | `[-5, 12]`         |           1           |
| 231 | (A2, B3, C1) | `[15, 20]`         |           2           |
| 311 | (A3, B1, C1) | `[5, 8, 9]`        |           0           |
| 322 | (A3, B2, C2) | `[5, -8, 12]`      |           1           |
| 332 | (A3, B3, C2) | `[-5, 15, 20, 25]` |           3           |

Coverage Matrices:

| A-B | B1  | B2  | B3  |
|:---:|:---:|:---:|:---:|
| A1  | 112 | 121 |  -  |
| A2  | 211 | 222 | 231 |
| A3  | 311 | 322 | 332 |

| A-C | C1  | C2  |
|:---:|:---:|:---:|
| A1  | 121 | 112 |
| A2  | 211 | 222 |
| A3  | 311 | 322 |

| B-C | C1  | C2  |
|:---:|:---:|:---:|
| B1  | 211 | 112 |
| B2  | 121 | 222 |
| B3  | 231 | 332 |

Fewer than 8 test cases would not be sufficient to achieve PWC because each of the 8 test cases must cover a unique A-B
pair. Since there are 8 unique A-B pairs and each test case covers exactly one pair, removing any test case would
eliminate coverage of one A-B pair and violate the PWC criterion.

#### (c)

| Variation    | Feasible? |
|--------------|-----------|
| (A3, B1, C1) | Yes       |
| (A1, B1, C1) | Yes       |
| (A2, B1, C1) | Yes       |
| (A3, B2, C1) | Yes       |
| (A3, B3, C1) | Yes       |
| (A3, B1, C2) | Yes       |

#### (d)

The proposed test M5 is infeasible because an array of length 1 cannot contain at least 2 entries greater than 10. The
developer also missed the feasible variation (A3, B2, C1). To repair the suite, remove M5 and replace it with (A3, B2,
C1). Retain the two base tests and all other feasible variations. Include the duplicated M3 only once.

| Test | Proposed tuple                |
|:----:|:------------------------------|
|  M1  | (A1, B1, C1)                  |
|  M2  | (A3, B1, C1)                  |
|  M3  | (A2, B1, C1)                  |
|  M4  | (A1, B2, C1)                  |
|  M5  | ~~(A1, B3, C1)~~ (A3, B2, C1) |
|  M6  | (A1, B1, C2)                  |
|  M7  | (A3, B3, C1)                  |
|  M8  | (A3, B1, C2)                  |
