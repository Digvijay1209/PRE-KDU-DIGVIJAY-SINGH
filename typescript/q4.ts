/*
  Create a utility function findById that takes an array of User objects and a number as arguments and returns a User | undefined (if the user with the given ID exists).
  Extend the function to support a new parameter, which specifies if the returned user should include undefined or throw an error. Use TypeScript's never type to represent the error-throwing case.
  Test the function using a sample array of User objects and handle both scenarios (with and without throwing an error).

  Export the function findById so that it can be used in the test file.
*/

export type User = {
  id: number;
  name: string;
  email: string;
};

export function findById(
  users: User[],
  id: number,
  throwOnError: boolean = false
): User | undefined | never {
  const user = users.find((user) => user.id === id);

  if (!user && throwOnError) {
    throw new Error(`User with ID ${id} not found`);
  }

  return user;
}
//Sample TestCase
const userArray: User[] = [
  { id: 1, name: "Alice", email: "alice@example.com" },
  { id: 2, name: "Bob", email: "bob@example.com" },
  { id: 3, name: "Charlie", email: "charlie@example.com" },
];


console.log("Scenario 1: User Found");
const user1 = findById(userArray, 1);
console.log(user1); 


// Scenario 2: User not found (Return undefined)
console.log("\nScenario 2: User Not Found (No Error)");
const user2 = findById(userArray, 4);
console.log(user2); 


// Scenario 3: User not found (Throw error)
console.log("\nScenario 3: User Not Found (Throw Error)");
try {
  const user3 = findById(userArray, 4, true); 
  console.log(user3); 
} catch (error) {
  console.log(error.message); 
}