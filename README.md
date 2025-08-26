# Final Project — [tbcbank.ge](https://tbcbank.ge/) — 500 points

---

## Goal
Build a clean, maintainable **UI automation suite** using **Java + Selenide + TestNG.**
You must document scenarios in **Zephyr Scale** and **automate only what you documented.**

---

## Tech Stack (Fixed)
- **Java, Selenide, TestNG, Maven.**

---

## Architecture rules
- **Page Objects:** selectors only.
- **Steps layer:** encapsulate interactions & assertions.
- **Tests:** orchestrate flows only (no raw selectors).

---

## Selected Scope (Scenarios)
- **Search By Keyword Filter on Location Page**
    - Location filter (keyword) updates map + list; details visible

- **Tabs & Sub-tabs Validation on Location Page**
    - Tabs & sub-tabs (Branch/ATM + services like 24/7, Open now)

- **Validation of Global Search By Keyword**
    - Search: site search by keyword; validate results list and empty state.

- **Card Type Filters Validity on All-Offers Page**
    - Offers: apply filters; validate results; reset filters restores defaults

- **Mobile Hamburger Menu & Sticky Navbar Validation**
    - Mobile-specific: hamburger menu behavior; sticky header; key CTA visible in mobile viewport.


---

## Benefits
- Cross Platform Validation for most scenarios (Except for Mobile-specific one)

---

- TODO: Fix Chrome specific bug. Base Test already supports different browsers, however there is issue with how chrome handles clicking.