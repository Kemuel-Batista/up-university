import {
  Entity,
  PrimaryGeneratedColumn,
  Column,
  OneToMany,
  CreateDateColumn,
  UpdateDateColumn,
} from "typeorm";
import { Product } from "./product";

@Entity()
export class Category {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ unique: true })
  name: string;

  @Column({ nullable: true })
  description: string;

  @OneToMany(() => Product, (product) => product.categoryId)
  products: Product[];

  @CreateDateColumn({ name: "date_created" })
  dateCreated: Date;

  @UpdateDateColumn({ name: "date_updated" })
  dateUpdated: Date;
}
