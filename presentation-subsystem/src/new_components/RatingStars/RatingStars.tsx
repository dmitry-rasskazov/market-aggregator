import React from 'react';
import styles from './ProductCard.module.css';

interface RatingStarsProps {
  rating: number;
  size: 'small' | 'large';
}

const RatingStars: React.FC<RatingStarsProps> = ({ rating, size }) => {
  const stars = [];
  const fullStars = Math.floor(rating);
  const hasHalfStar = rating % 1 !== 0;

  for (let i = 0; i < 5; i++) {
    if (i < fullStars) {
      stars.push(
        <img
          key={i}
          src={`https://dashboard.codeparrot.ai/api/image/Z9k5ASppvFKitUWP/full-star${size === 'small' ? '-4' : ''}.png`}
          alt="full star"
          className={size === 'small' ? styles.smallStar : styles.largeStar}
        />
      );
    } else if (i === fullStars && hasHalfStar) {
      stars.push(
        <img
          key={i}
          src={`https://dashboard.codeparrot.ai/api/image/Z9k5ASppvFKitUWP/half-star${size === 'small' ? '-2' : ''}.png`}
          alt="half star"
          className={size === 'small' ? styles.smallStar : styles.largeStar}
        />
      );
    } else {
      stars.push(
        <img
          key={i}
          src={`https://dashboard.codeparrot.ai/api/image/Z9k5ASppvFKitUWP/star${size === 'small' ? '-2' : ''}.png`}
          alt="empty star"
          className={size === 'small' ? styles.smallStar : styles.largeStar}
        />
      );
    }
  }
  return <>{stars}</>;
};

export default RatingStars;
