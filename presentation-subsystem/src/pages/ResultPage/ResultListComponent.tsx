import React from 'react';
import styles from './ResultListComponent.module.css';

interface ResultListComponentProps {
  className?: string;
}

interface ResultItem {
  title: string;
  description: string;
  price: string;
  image: string;
  rating: number;
  vendorRating: number;
  vendorName: string;
}

const ResultListComponent: React.FC<ResultListComponentProps> = ({ className }) => {
  // Mock data - in real app would come from props/API
  const results: ResultItem[] = [
    {
      title: "Набор инструментов для ремонта",
      description: "Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска...",
      price: "222,23 ₽/шт",
      image: "https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/short-ima.png",
      rating: 3.5,
      vendorRating: 4.5,
      vendorName: "Short vendor's name..."
    },
    // Repeated items with different images
    {
      title: "Набор инструментов для ремонта",
      description: "Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска...",
      price: "222,23 ₽/шт", 
      image: "https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/short-ima-2.png",
      rating: 3.5,
      vendorRating: 4.5,
      vendorName: "Short vendor's name..."
    },
    {
      title: "Набор инструментов для ремонта",
      description: "Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска...",
      price: "222,23 ₽/шт",
      image: "https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/short-ima-3.png", 
      rating: 3.5,
      vendorRating: 4.5,
      vendorName: "Short vendor's name..."
    },
    {
      title: "Набор инструментов для ремонта",
      description: "Краткое описание, как правило, первая часть основного описания, ограничено доступной длиной части кратного описания результата поиска...",
      price: "222,23 ₽/шт",
      image: "https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/short-ima-4.png",
      rating: 3.5,
      vendorRating: 4.5,
      vendorName: "Short vendor's name..."
    }
  ];

  const renderStars = (rating: number, size: 'small' | 'large') => {
    const fullStars = Math.floor(rating);
    const hasHalfStar = rating % 1 >= 0.5;
    const stars = [];

    for (let i = 0; i < 5; i++) {
      if (i < fullStars) {
        stars.push(
          <img 
            key={`full-${i}`}
            src={`https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/full-star${size === 'small' ? '-' + (i + 19) : '-' + (i + 1)}.png`}
            className={size === 'small' ? styles.smallStar : styles.largeStar}
            alt="Full star"
          />
        );
      } else if (i === fullStars && hasHalfStar) {
        stars.push(
          <img 
            key="half"
            src={`https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/half-star${size === 'small' ? '-8' : ''}.png`}
            className={size === 'small' ? styles.smallStar : styles.largeStar}
            alt="Half star"
          />
        );
      } else {
        stars.push(
          <img 
            key={`empty-${i}`}
            src={`https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/star${size === 'small' ? '-8' : ''}.png`}
            className={size === 'small' ? styles.smallStar : styles.largeStar}
            alt="Empty star"
          />
        );
      }
    }
    return stars;
  };

  return (
    <div className={`${styles.container} ${className || ''}`}>
      {results.map((item, index) => (
        <div key={index} className={styles.resultItem}>
          <div className={styles.shortPriceBlock}>
            <img src={item.image} alt="Product" className={styles.productImage} />
            <div className={styles.price}>{item.price}</div>
          </div>
          
          <div className={styles.nameDescription}>
            <div className={styles.title}>
              <a href="#" className={styles.titleLink}>{item.title}</a>
            </div>
            <div className={styles.description}>
              {item.description}
            </div>
            <div className={styles.ratingContainer}>
              <div className={styles.productRating}>
                {renderStars(item.rating, 'large')}
              </div>
              <div className={styles.vendorField}>
                <div className={styles.vendorRating}>
                  {renderStars(item.vendorRating, 'small')}
                </div>
                <span className={styles.vendorName}>{item.vendorName}</span>
              </div>
            </div>
          </div>
        </div>
      ))}
      
      <div className={styles.pagination}>
        <div className={styles.numbers}>
          <span className={styles.pageNumber}>1</span>
          <span className={styles.pageNumber}>2</span>
          <span className={styles.pageNumber}>3</span>
          <span className={styles.ellipsis}>...</span>
          <span className={styles.pageNumber}>99</span>
        </div>
      </div>
    </div>
  );
};

export default ResultListComponent;

