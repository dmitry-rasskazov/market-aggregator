import React from 'react';
import Typography from '@mui/material/Typography';
import styles from './ProductHeader.module.css';

interface ProductHeaderProps {
  title?: string;
  searchText?: string;
  resultsText?: string;
}

const ProductHeader: React.FC<ProductHeaderProps> = ({
  title = "Полное наименование продукта. Может включать несколько предложений",
  searchText = "Поиск",
  resultsText = "Результаты"
}) => {
  return (
    <header className={styles.header}>
      <nav className={styles.navigation}>
        <Typography variant="body1" component="span">{searchText}</Typography>
        <Typography variant="body1" component="span" className={styles.arrow}>→</Typography>
        <Typography variant="body1" component="span">{resultsText}</Typography>
      </nav>
      
      <div className={styles.titleContainer}>
        <Typography variant="h6" component="h1" className={styles.title}>{title}</Typography>
        <button className={styles.menuButton}>
          <img 
            src="https://dashboard.codeparrot.ai/api/image/Z9lB0yppvFKitUWb/menu-icon.png" 
            alt="Menu"
            width={80}
            height={64}
          />
        </button>
      </div>
    </header>
  );
};

export default ProductHeader;

