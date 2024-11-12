import { createConnection } from "typeorm";
import { CampaignProduct } from "../entities/CampaignProduct";
import { Campaign } from "../entities/Campaign";
import { Product } from "../entities/Product";
import { User } from "../entities/User";

export const connectDB = async (isPostgres: boolean) => {
  const connection = await createConnection({
    type: isPostgres ? "postgres" : "mongodb",
    url: isPostgres
      ? process.env.POSTGRES_CONNECTION_URL
      : process.env.MONGODB_CONNECTION_URL,
    entities: [Campaign, Product, User, CampaignProduct],
    synchronize: true, // TO DO: Retirar em produção
    logging: true,
    useUnifiedTopology: true,
  });

  console.log(`Connected to ${isPostgres ? "PostgreSQL" : "MongoDB"}`);
  return connection;
};
