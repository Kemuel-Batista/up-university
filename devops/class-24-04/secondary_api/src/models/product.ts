import {
  Entity,
  PrimaryGeneratedColumn,
  Column,
  ManyToOne,
  CreateDateColumn,
  UpdateDateColumn,
} from "typeorm";
import { Category } from "./category";

@Entity()
export class Product {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  name: string;

  @Column({ nullable: true })
  description: string;

  @Column("decimal", { precision: 10, scale: 2 })
  price: number;

  @Column()
  quantity: number;

  @ManyToOne(() => Category, (category) => category.products, { eager: true })
  categoryId: Category;

  @CreateDateColumn({ name: "date_created" })
  dateCreated: Date;

  @UpdateDateColumn({ name: "date_updated" })
  dateUpdated: Date;
}
