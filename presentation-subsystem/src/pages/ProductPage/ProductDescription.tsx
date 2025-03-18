import React from 'react';
import Typography from '@mui/material/Typography';
import styles from './ProductDescription.module.css';

interface ProductDescriptionProps {
  title?: string;
  description?: string;
}

const ProductDescription: React.FC<ProductDescriptionProps> = ({
  title = 'Описание',
  description = 'Произвольный текст описания.\nОписание ввиде многострочного текста, произвольного формата.\nМожет содержать любую информацию и распространяться сколько нужно вниз.'
}) => {
  return (
    <div className={styles.container}>
      <Typography variant="h4" className={styles.title}>{title}</Typography>
      <Typography variant="body1" className={styles.description}>{description}</Typography>
    </div>
  );
};

export default ProductDescription;

