'use client';

import Dropdown from "@/components/DropdownProps";
import { ListTask } from "@/app/api/list-tasks/route";
import { Tag } from "@/app/api/tags/route";

export default function SideBar({
  listTask,
  tagData,
}: {
  listTask: ListTask[];
  tagData: Tag[]; 
}) {
  return (
    <div className="w-[20vw] h-screen bg-white flex flex-col gap-5 justify-start items-center py-4">
        <h2 className="text-2xl font-semibold mb-5">My Tasks</h2>
      <Dropdown title="List of tasks" data={listTask} />
      
      <Dropdown title="Tags" data={tagData} isTag={true} />
    </div>
  );
}
