import { Injectable } from '@nestjs/common';
import { Todo } from './interfaces/todo.interface';
import { TodosRepository } from './todos.repository';

@Injectable()
export class TodosService {
  constructor(private todosRepository: TodosRepository) {}

  async findAll(): Promise<Todo[]> {
    return await this.todosRepository.findAll();
  }

  async findOne(id: string): Promise<Todo> {
    return this.todosRepository.findOne(id);
  }
}
