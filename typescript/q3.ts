/*
  Define a generic function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] that filters an array based on a predicate function.
  Use this function to filter an array of numbers and return only even numbers.
  Use the same function to filter an array of User objects and return users whose email includes "@company.com".

  Export the filterArray function so that the code can be tested in the test file.
*/



export type User = {
  id: number;
  name: string;
  email: string;
  role?: string; // Made the role property optional
};

export function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] {
  return arr.filter(predicate);
}

// Sample Test Case 1
const numbers = [1, 2, 3, 4, 5];
const result = filterArray(numbers, (num) => num % 2 === 0);
console.log(result); // Output: [2, 4]

// Sample Test Case 2
const users: User[] = [
  { id: 1, name: "Alice", email: "alice@company.com", role: "Manager" },
  { id: 2, name: "Bob", email: "bob@example.org" },
  { id: 3, name: "Charlie", email: "charlie@company.com", role: "CEO" },
];

const result2 = filterArray(users, (user) => user.email.includes("@company.com"));
console.log(result2);
// Output: [{ id: 1, name: "Alice", email: "alice@company.com", role: "Manager" }, { id: 3, name: "Charlie", email: "charlie@company.com", role: "CEO" }]

