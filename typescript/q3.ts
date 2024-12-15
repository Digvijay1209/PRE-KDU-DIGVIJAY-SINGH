/*
  Define a generic function filterArray<T>(arr: T[], predicate: (item: T) => boolean): T[] that filters an array based on a predicate function.
  Use this function to filter an array of numbers and return only even numbers.
  Use the same function to filter an array of User objects and return users whose email includes "@company.com".

  Export the filterArray function so that the code can be tested in the test file.
*/

export function filterArray<T>(arr: T[],predicate:(item:T)=>boolean):T[]{
  return arr.filter(predicate);
}

// Sample testCase:
const numbers = [1, 2, 3, 4, 5];
const result = filterArray(numbers, (num) => num % 2 === 0); 
console.log(result); 

// Sample Testcase 2
type User = {
  id: number;
  name: string;
  email: string;
  role: string | undefined;
};

const users: User[] = [
  { id: 1, name: "Alice", email: "alice@company.com", role: "Manager" },
  { id: 2, name: "Bob", email: "bob@example.org", role: "Developer" },
  { id: 3, name: "Charlie", email: "charlie@company.com", role: "CEO" }
];


const result2 = filterArray(users, (user) => user.email.includes("@company.com"));

console.log(result2);