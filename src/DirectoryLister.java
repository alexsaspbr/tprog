import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DirectoryLister {
  public static List<String> listTree(File start, String indent, List<String> out) {
    if (!start.isDirectory()) {
      out.add(indent + start.getName());
      return out;
    }
    File[] childrenArray = start.listFiles();
    if (childrenArray == null) {
      return out;
    }
    List<File> children = Arrays.stream(childrenArray)
        .filter(Objects::nonNull)
        .sorted(Comparator
            .<File>comparingInt(f -> f.isDirectory() ? 0 : 1)
            .thenComparing(File::getName)
        )
        .collect(Collectors.toList());

    for (File child : children) {
      String line = indent + child.getName();
      if (child.isDirectory()) {
        out.add(line + "/");
        listTree(child, "  " + indent, out); // <- recursão
      } else {
        out.add(line);
      }
    }

    return out;
  }

}
