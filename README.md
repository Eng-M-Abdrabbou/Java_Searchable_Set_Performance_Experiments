Java Searchable Set Performance Experiments
===================================

## Project Overview

This repository contains a comprehensive performance analysis of different `SearchableSet` implementations in Java. We explored three distinct approaches to implementing a set data structure and rigorously tested their performance characteristics.

## Project Objective

The goal of this project was to compare the performance of three different `SearchableSet` implementations:
1. **ArrayBag**: A basic array-based implementation
2. **Sorted ArrayList**: An ArrayList with sorting and binary search
3. **HashSet**: Java's built-in hash-based set implementation

## Experimental Setup

### Data Sets
We used three key data sets for our performance experiments:
- `unique_ids.txt`: 60,000 unique IDs for adding to the sets
- `contained_ids.txt`: 20,000 IDs known to be in the sets
- `non_contained_ids.txt`: 20,000 IDs not in the sets

### Performance Metrics
We measured the time taken for:
- Adding all unique IDs
- Checking IDs that are present
- Checking IDs that are not present

## 🔬 Key Findings

![Performance Comparison Screenshot](/Images/scrn.png)

or textually:

| Operation | ArrayBag | Sorted ArrayList | HashSet |
|-----------|----------|-----------------|---------|
| Adding All IDs | 1.4 ms | 28.4 ms | 5.1 ms |
| Checking Present IDs | 3336.5 ms | 9.8 ms | 2.1 ms |
| Checking Non-Present IDs | 8405.3 ms | 11.5 ms | 1.0 ms |

### Performance Insights
- **ArrayBag**: Fast addition (O(1)), but extremely slow searching (O(N))
- **Sorted ArrayList**: Moderate performance with binary search (O(log N))
- **HashSet**: Optimal performance with near-constant time operations (O(1))

## Project Structure

* **`build/`**: Contains the compiled `.class` files generated after building the project.
* * **`Images/`**: Contains the compiled `.png` files generated after building and running the project to show the results of the experiment.
* **`nbproject/`**: Holds configuration files specific to the NetBeans Integrated Development Environment (IDE). This directory is usually not crucial for command-line builds or other IDEs.
* **`src/`**: Contains the source code for the Java project.
    * **`searchablesetproject/`**: The main package organizing the project's classes.
        * **`SearchableSetInterface.java`**: Defines the interface that all searchable set implementations must adhere to. It likely includes methods for adding, removing, and searching for elements.
        * **`ArrayBag.java`**: An implementation of the `BagInterface` using an array as the underlying data structure.
        * **`BagInterface.java`**: Defines the interface for a basic Bag data structure, which allows for duplicate elements.
        * **`BagSearchableSet.java`**: An implementation of the `SearchableSetInterface` that utilizes a `Bag` (likely `ArrayBag`) to store its elements.
        * **`HashSetSearchableSet.java`**: An implementation of the `SearchableSetInterface` that leverages the `java.util.HashSet` for efficient storage and searching.
        * **`ListSearchableSet.java`**: An implementation of the `SearchableSetInterface` that uses a `java.util.ArrayList` to store its elements.
        * **`SearchableSetProject.java`**: The main class containing the `main` method to execute the performance experiments and likely print the results.
* **`test/`**: This directory would typically contain JUnit test files to verify the correctness of the different `SearchableSetInterface` implementations. (Note: This directory is present but might be empty if tests haven't been written yet).
* **`build.xml`**: An Ant build script used to automate the compilation, execution, and packaging of the Java project.
* **`manifest.mf`**: A manifest file that contains metadata about the project, especially when creating a JAR (Java Archive) file.
* **`README.md`**: This file, providing an overview and documentation for the project.
* **`unique_ids.txt`**: A text file containing a set of unique identifiers used as data for performance tests, particularly for operations like adding elements.
* **`contained_ids.txt`**: A text file containing a subset of identifiers that are expected to be present in the searchable sets during search performance tests.
* **`non_contained_ids.txt`**: A text file containing a set of identifiers that are expected to be absent from the searchable sets during search performance tests.


## 🏃 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Steps
1. Clone the repository
```bash
git clone https://github.com/Eng-M-Abdrabbou/Java_Searchable_Set_Performance_Experiments.git
```
2. Navigate to the source directory
```bash
cd Java_Searchable_Set_Performance_Experiments/src
```

3. Compile and run the project
```bash
javac SearchableSetProject.java
java SearchableSetProject
```

## Conclusion

HashSet emerged as the clear performance winner, demonstrating the power of hash-based data structures for set operations.

## Acknowledgments
- Java Documentation for invaluable resources
