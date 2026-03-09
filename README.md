# Duck Pond Simulator - Design Patterns Project

## Overview
This Java project demonstrates the implementation and practical application of seven key Object-Oriented Design Patterns. It simulates a duck pond environment where various types of ducks and geese interact, quack, and are tracked using multiple design patterns working together in harmony.

---

## Design Patterns Used

### 1. **Interface Pattern**
**File:** `Quackable.java`

The Interface Pattern defines a contract that all quackable objects must implement. This pattern establishes a common interface for different types of objects that can quack.

**Purpose:**
- Define a uniform interface for all duck types (MallardDuck, RedheadDuck, RubberDuck, adapted Geese)
- Enable polymorphic behavior across different duck implementations

**Implementation:**
- `Quackable` interface defines the `quack()` method
- All duck classes implement the `Quackable` interface
- Allows clients to work with any Quackable object without knowing its concrete type

**Benefits:**
- Promotes loose coupling between client code and concrete implementations
- Makes it easy to add new duck types in the future
- Ensures consistent behavior across all quackable objects

---

### 2. **Adapter Pattern**
**File:** `GooseDuckAdapter.java`

The Adapter Pattern converts the interface of an incompatible class into an interface that clients expect. This pattern allows incompatible objects to work together.

**Purpose:**
- Adapt `Goose` and `WildGoose` objects to work with the `Quackable` interface
- Treat geese as ducks without modifying the original Goose class

**Implementation:**
- `GooseDuckAdapter` wraps a `Goose` object
- Implements the `Quackable` interface
- Adapts `Goose.honk()` calls to the `Quackable.quack()` interface
- The adapter delegates calls to the wrapped Goose instance

**Benefits:**
- Allows existing classes to be reused with new interfaces
- No modification needed to the original Goose class
- Maintains Open/Closed Principle (open for extension, closed for modification)

---

### 3. **Decorator Pattern**
**File:** `QuackCounter.java`

The Decorator Pattern adds additional responsibilities to an object dynamically, without altering its underlying structure. It's an alternative to subclassing.

**Purpose:**
- Add counting functionality to any `Quackable` object
- Track how many times a duck quacks without modifying the duck classes

**Implementation:**
- `QuackCounter` wraps a `Quackable` object
- Implements `Quackable` interface
- Maintains a static counter to track total quacks
- Increments counter each time the wrapped quackable quacks
- Delegates the actual quack to the wrapped object

**Benefits:**
- Adds behavior without modifying the original classes
- Can be applied to any Quackable object at runtime
- Supports flexible composition of responsibilities
- Follows Single Responsibility Principle

---

### 4. **Factory Pattern**
**Files:** `DuckFactory.java`, `CountingDuckFactory.java`

The Factory Pattern provides an interface for creating objects without specifying their exact classes. It encapsulates object creation logic.

**Purpose:**
- Centralize the creation of duck objects
- Provide different factory implementations for various creation strategies
- Abstract away the instantiation process

**Implementation:**

**DuckFactory:**
- Creates MallardDuck, RedheadDuck, and RubberDuck instances
- Encapsulates the creation logic in a single location
- Returns `Quackable` interface (not concrete types)

**CountingDuckFactory:**
- Extends the factory functionality
- Creates ducks wrapped with `QuackCounter` decorator
- Enables automatic quack counting on all created ducks

**Benefits:**
- Centralizes object creation logic
- Makes it easy to change object creation strategy
- Reduces coupling between client code and concrete duck classes
- Supports different factory implementations for different needs

---

### 5. **Composite Pattern**
**File:** `Flock.java`

The Composite Pattern composes objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions uniformly.

**Purpose:**
- Treat a collection of ducks (Flock) the same way as individual ducks
- Build hierarchies of flocks (flocks of flocks)
- Perform operations on groups of ducks without special handling

**Implementation:**
- `Flock` implements `Quackable` interface
- Maintains a collection of `Quackable` objects (individual ducks or other flocks)
- Delegates `quack()` calls to all contained quackables
- Can add ducks and other flocks to a Flock using `addQuackable()`

**Benefits:**
- Simplifies client code by treating individual and composite objects uniformly
- Makes it easy to build complex hierarchies
- Supports recursive composition (flocks containing flocks)
- Follows Open/Closed Principle

---

### 6. **Iterator Pattern**
**File:** `Flock.java` (implements `Iterable<Quackable>`)

The Iterator Pattern provides a way to access elements of a collection sequentially without exposing its underlying representation.

**Purpose:**
- Iterate through all ducks in a Flock without exposing the internal collection structure
- Support the enhanced for-loop syntax in Java
- Provide a uniform way to traverse the collection

**Implementation:**
- `Flock` implements `Iterable<Quackable>`
- Provides an `iterator()` method that returns an iterator
- Allows external code to iterate through quackables without knowing the collection type
- Supports Java's enhanced for-loop syntax

**Benefits:**
- Decouples client code from collection implementation details
- Supports multiple simultaneous iterations
- Enables clean, readable iteration syntax
- Makes it easy to change the internal collection structure

---

### 7. **Observer Pattern**
**Files:** `QuackObserver.java`, `QuackEvent.java`, `QuackTracker.java`, `ObservableQuackable.java`

The Observer Pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically.

**Purpose:**
- Track and observe quacking events in real-time
- Allow multiple observers to respond to duck quacks
- Decouple observers from the quacking objects

**Implementation:**

**QuackObserver Interface:**
- Defines the contract for objects that want to observe quacking events
- Declares `update(QuackEvent event)` method

**QuackEvent:**
- Encapsulates information about a quacking event
- Contains the quackable object that quacked
- Provides details about the quacking event

**ObservableQuackable:**
- Wraps a `Quackable` object
- Maintains a list of registered `QuackObserver` objects
- Notifies all observers when the wrapped quackable quacks
- Provides methods to `addObserver()` and `removeObserver()`

**QuackTracker:**
- Implements `QuackObserver` interface
- Tracks and logs all quacking events
- Responds to notifications by processing quacking data

**Benefits:**
- Decouples observers from observables (ducks)
- Supports multiple observers without modifying the observable
- Automatic notification mechanism when state changes
- Easy to add/remove observers at runtime
- Follows Open/Closed Principle
