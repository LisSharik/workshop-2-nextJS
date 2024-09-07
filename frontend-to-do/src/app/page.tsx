'use client';

import { useEffect, useState } from "react";
import SideBar from "@/components/SideBar";
import { fetchListTasks, fetchTags } from "@/app/api/apiDb";
import { ListTask } from "@/app/api/list-tasks/route";
import { Tag } from "@/app/api/tags/route";

export default function Home() {
  const [listTasks, setListTasks] = useState<ListTask[]>([]);
  const [tags, setTags] = useState<Tag[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function fetchData() {
      try {
        const listTaskData = await fetchListTasks(); 
        const tagData = await fetchTags(); 

 

        setListTasks(listTaskData);
        setTags(tagData);
      } catch (error) {
        console.error("Error fetching data: ", error); 
      } finally {
        setLoading(false);
        console.log("Data fetching complete."); 
      }
    }
    
    fetchData(); 
  }, []);

  if (loading) {
    return <div className="w-screen h-screen bg-neutral-300 flex justify-center items-center">
      <h1 className="text-4xl font-bold">Loading...</h1>
    </div>; 
  }

  return (
    <div className="w-screen h-screen flex justify-between items-start">
      <SideBar listTask={listTasks} tagData={tags} />
      <h1>Hello Next.js</h1>
    </div>
  );
}
