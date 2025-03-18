import React from 'react';
import styles from './ResultItem.module.css';

interface ResultItemProps {
  title?: string;
  description?: string;
  price?: string;
  image?: string;
  rating?: number;
  vendorRating?: number;
  vendorName?: string;
}

const ResultItem: React.FC<ResultItemProps> = ({
  title = "Набор инструментов для ремонта",
  description = "Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска...",
  price = "222,23 ₽/шт",
  image = "https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/short-ima.png",
  rating = 3.5,
  vendorRating = 4.5,
  vendorName = "Short vendor's name..."
}) => {

  const renderStars = (rating: number, size: 'small' | 'large') => {
    const stars = [];
    const fullStars = Math.floor(rating);
    const hasHalfStar = rating % 1 !== 0;

    for (let i = 0; i < 5; i++) {
      if (i < fullStars) {
        stars.push(
          <img 
            key={`full-${i}`}
            src={`https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/full-star${size === 'small' ? '-4' : ''}.png`}
            className={size === 'small' ? styles.smallStar : styles.star}
            alt="full star"
          />
        );
      } else if (i === fullStars && hasHalfStar) {
        stars.push(
          <img 
            key="half"
            src={`https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/half-star${size === 'small' ? '-2' : ''}.png`}
            className={size === 'small' ? styles.smallStar : styles.star}
            alt="half star"
          />
        );
      } else {
        stars.push(
          <img 
            key={`empty-${i}`}
            src={`https://dashboard.codeparrot.ai/api/image/Z9k665IdzXb5Olaz/star${size === 'small' ? '-2' : ''}.png`}
            className={size === 'small' ? styles.smallStar : styles.star}
            alt="empty star"
          />
        );
      }
    }
    return stars;
  };

  return (
    <div className={styles.resultItem}>
      <div className={styles.shortPriceBlock}>
        <img src={image} alt={title} className={styles.productImage} />
        <div className={styles.price}>{price}</div>
      </div>
      
      <div className={styles.nameDescription}>
        <div className={styles.titleContainer}>
          <h2 className={styles.title}>{title}</h2>
        </div>
        
        <div className={styles.descriptionContainer}>
          <p className={styles.description}>{description}</p>
        </div>
        
        <div className={styles.ratingContainer}>
          <div className={styles.productRating}>
            {renderStars(rating, 'large')}
          </div>
          
          <div className={styles.vendorRating}>
            <div className={styles.vendorStars}>
              {renderStars(vendorRating, 'small')}
            </div>
            <span className={styles.vendorName}>{vendorName}</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ResultItem;

