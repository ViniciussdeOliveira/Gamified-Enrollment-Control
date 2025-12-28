# Gamified Enrollment Control

A Gamified Enrollment Control system built in **Kotlin**, applying Object-Oriented Programming (OOP) concepts and Kotlin-specific idioms.

## Project Overview

This project simulates an E-learning platform domain. It handles user enrollments, calculates Experience Points (XP) based on course difficulty, and validates business rules using clean architecture principles.

## Key Features & Concepts

* **Kotlin Idioms:** Extensive use of `data classes`, `enums`, and collections.
* **Domain-Specific Language (DSL):** Utilizes **Infix Functions** and **Extension Functions** to create readable, sentence-like code (e.g., `user matriculouEm course`).
* **Gamification Logic:** XP calculation logic encapsulated within Enums and Domain classes.
* **Business Rules:** Prevention of duplicate enrollments and safe state management (Encapsulation).

## Tech Stack

* Kotlin

## Usage Example

```kotlin
val user = Usuario("User")
val course = Formacao("Kotlin Expert", contents, Nivel.HARD)

// Infix syntax in action:
user matriculouEm course
```