import { LIST_TASKS_URL, TAG_URL } from "./URLS";

export async function fetchListTasks() {
  const response = await fetch(LIST_TASKS_URL);
  if (!response.ok) {
    throw new Error("Failed to fetch List Tasks");
  }
  const data = await response.json();
  return data.content; 
}

export async function fetchTags() {
  const response = await fetch(TAG_URL);
  if (!response.ok) {
    throw new Error("Failed to fetch Tags");
  }
  const data = await response.json();
  return data.content; 
}


