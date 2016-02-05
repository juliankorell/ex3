// Copyright 2015, University of Freiburg,
// Chair of Algorithms and Data Structures.
// Author: Hannah Bast <bast@cs.uni-freiburg.de>.

import java.util.Arrays;
import org.junit.Test;
import org.junit.Assert;
import java.io.IOException;

/**
 * One unit test for each non-trivial method in the InvertedIndex class.
 */
public class ListIntersectionTest {

  @Test
  public void readPostingList() throws IOException {
    ListIntersection li = new ListIntersection();
    PostingList list1 = li.readPostingList("example1.txt", 2, 50);
    Assert.assertEquals("[10, 20, 30, 60, 70, 80, 2147483647]",
            Arrays.toString(list1.ids));
    Assert.assertEquals("[1, 2, 3, 1, 2, 3, 2147483647]",
            Arrays.toString(list1.scores));
    PostingList list2 = li.readPostingList("example2.txt", 2, 50);
    Assert.assertEquals("[10, 20, 40, 60, 70, 90, 2147483647]",
            Arrays.toString(list2.ids));
    Assert.assertEquals("[1, 2, 4, 1, 2, 4, 2147483647]",
            Arrays.toString(list2.scores));
  }

  @Test
  public void intersect() throws IOException {
    ListIntersection li = new ListIntersection();
    PostingList list1 = li.readPostingList("example1.txt", 2, 50);
    PostingList list2 = li.readPostingList("example2.txt", 2, 50);
    PostingList list = li.intersect(list1, list2);
    int maxValue = Integer.MAX_VALUE;
    Assert.assertEquals("[10, 20, 60, 70, 2147483647]",
            Arrays.toString(list.ids));
    Assert.assertEquals("[2, 4, 2, 4, 2147483647]",
            Arrays.toString(list.scores));
  }
}
