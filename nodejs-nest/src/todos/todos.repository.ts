import { Injectable } from '@nestjs/common';
import { Todo } from './interfaces/todo.interface';
import { promises as fs } from 'fs';
import path from 'path';

interface File {
  todos: Todo[];
}

@Injectable()
export class TodosRepository {
  async findAll(): Promise<Todo[]> {
    const file = await this.readFile();
    return file.todos;
  }

  async findOne(id: string): Promise<Todo> {
    const file = await this.readFile();
    return file.todos.find((todo) => todo.id === Number(id));
  }

  private async readFile(): Promise<File> {
    const text = await fs.readFile('dist/todos/data.json', 'utf-8');
    const file = JSON.parse(text) as File;
    return file;
  }
}
