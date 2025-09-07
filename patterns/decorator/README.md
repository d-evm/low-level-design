# Decorator Pattern in Java

## What is Decorator Pattern?

The **Decorator Pattern** allows you to **add extra functionality to an object at runtime** without modifying its original class.

- Think of it like **wrapping a gift** 🎁 — the core object stays the same, but you can wrap it in different decorators to extend its behavior.
- It uses **composition (HAS-A relationship)** rather than inheritance, making it more flexible.

---

## Examples in This Repository

### 1. `CoffeeShop.java`

A simple example simulating a coffee shop where you can **dynamically add ingredients** to a coffee:

- **Component Interface**: `Coffee` — defines `getDescription()` and `getCost()`.
- **Concrete Component**: `SimpleCoffee` — plain coffee without any extras.
- **Decorators**: `MilkDecorator`, `SugarDecorator`, `CaramelDecorator` — wrap the base coffee and add extra description and cost.
- **Client**: Dynamically wraps a `SimpleCoffee` with multiple decorators at runtime.

**Purpose**: Demonstrates how decorators can be stacked dynamically, avoiding the need for a separate subclass for every possible combination.

---

### 2. `DecoratorExample.java`

A real-world example using **Java I/O streams** for writing **plain text**:

- **Component**: `FileWriter` — writes text to a file.
- **Decorators**:
    - `BufferedWriter` — adds buffering for efficiency.
    - `PrintWriter` — provides convenient methods like `println()`.
- **Client**: Wraps one writer inside another to add extra functionality without modifying the original `FileWriter`.

**Purpose**: Shows a practical use of decorators in Java standard libraries for **writing text efficiently and conveniently**.

**Output** in `output.txt`:
