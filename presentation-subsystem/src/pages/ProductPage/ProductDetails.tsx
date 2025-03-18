import React from 'react';
import styles from './ProductDetails.module.css';
import Rating from '@mui/material/Rating';
import Typography from '@mui/material/Typography';

interface ProductDetailsProps {
  imageUrl?: string;
  price?: number;
  rating?: number;
}

const ProductDetails: React.FC<ProductDetailsProps> = ({
  imageUrl = 'https://dashboard.codeparrot.ai/api/image/Z9lB0yppvFKitUWb/ремонт-2.png',
  price = 222.23,
  rating = 3.5
}) => {
  return (
    <div className={styles.container}>
      <div className={styles.imageContainer}>
        <img src={imageUrl} alt="Product" className={styles.productImage} />
      </div>
      <div className={styles.ratingContainer}>
        <Rating
          name="product-rating"
          value={rating}
          precision={0.5}
          readOnly
          className={styles.stars}
        />
      </div>
      <div className={styles.priceContainer}>
        <Typography variant="h6" className={styles.price}>
          {price.toFixed(2)} ₽
        </Typography>
      </div>
    </div>
  );
};

export default ProductDetails;

