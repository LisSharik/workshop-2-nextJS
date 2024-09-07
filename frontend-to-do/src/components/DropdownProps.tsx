"use client";

import { useState } from "react";
import { ListTask } from "@/app/api/list-tasks/route";
import { Tag } from "@/app/api/tags/route";

interface DropdownProps<T> {
  title: string;
  data: T[];
  isTag?: boolean;

}

export default function Dropdown<T extends ListTask | Tag>({
  title,
  data,
  isTag = false,
}: DropdownProps<T>) {
  const [isOpen, setIsOpen] = useState(false); 

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  return (
    <div className="w-full text-xl ">
      <button
        onClick={toggleDropdown}
        className="w-full flex justify-between items-center py-2 px-4 font-semibold text-left pl-10 transition-all hover:bg-gray-200 rounded-sm"
      >
        <p>{title}</p>
        <i
          className={`bx bx-chevron-down ${isOpen && "bx-rotate-180"} text-3xl`}
        ></i>
      </button>

      {isOpen && (
        <ul className="w-full flex flex-col justify-center items-center">
          {data.map((item) => (
            <li
              key={item.id}
              className={`w-full flex justify-start gap-3 items-center p-2 pl-16 text-lg cursor-pointer text-neutral-600 hover:bg-gray-200 ${
                isTag ? "text-blue-500" : ""
              }`}
            >
              {isTag && (
                <div
                  className="w-2 h-2 rounded-full"
                  style={{ backgroundColor: (item as Tag).color }} 
                ></div>
              )}
              {item.name}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
