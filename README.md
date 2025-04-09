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

Java_Searchable_Set_Performance_Experiments/
├── build/                  # Build output directory
├── nbproject/              # NetBeans project configuration
├── src/                    # Source code
│   └── searchablesetproject/
│       ├── SearchableSetInterface.java
│       ├── ArrayBag.java
│       ├── BagInterface.java
│       ├── BagSearchableSet.java
│       ├── HashSetSearchableSet.java
│       ├── ListSearchableSet.java
│       └── SearchableSetProject.java
├── test/                   # Test source files
├── build.xml               # Ant build script
├── manifest.mf             # Manifest file
├── README.md               # Project documentation
├── unique_ids.txt          # Performance test data set
├── contained_ids.txt       # Performance test data set
└── non_contained_ids.txt   # Performance test data set

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