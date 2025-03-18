import React from 'react';
import Card from '@mui/material/Card';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import RatingStars from '../RatingStars/RatingStars';
import styles from './ProductCard.module.css';

interface ProductCardProps {
  title: string;
  description: string;
  price: string;
  rating: number;
  vendorRating: number;
  vendorName: string;
  imageUrl: string;
}

const ProductCard: React.FC<ProductCardProps> = ({
  title = 'Набор инструментов для ремонта',
  description = 'Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска...',
  price = '222,23 ₽/шт',
  rating = 3.5,
  vendorRating = 3.5,
  vendorName = "Short vendor's name...",
  imageUrl = 'https://dashboard.codeparrot.ai/api/image/Z9k5ASppvFKitUWP/short-ima.png'
}) => {
  return (
    <Card className={styles.container}>
      <div className={styles.shortPriceBlock}>
        <CardMedia
          component="img"
          image={imageUrl}
          alt="Product"
          className={styles.productImage}
        />
        <Typography variant="h6" className={styles.price}>{price}</Typography>
      </div>
      
      <CardContent className={styles.nameDescription}>
        <Typography variant="h5" component="a" href="#" className={styles.title}>
          {title}
        </Typography>
        <Typography variant="body2" className={styles.description}>
          {description}
        </Typography>
        <div className={styles.ratingContainer}>
          <div className={styles.productRating}>
            <RatingStars rating={rating} size="large" />
          </div>
          <div className={styles.vendorRating}>
            <div className={styles.stars}>
              <RatingStars rating={vendorRating} size="small" />
            </div>
            <Typography variant="body2" className={styles.vendorName}>
              {vendorName}
            </Typography>
          </div>
        </div>
      </CardContent>
    </Card>
  );
};

export default ProductCard;
