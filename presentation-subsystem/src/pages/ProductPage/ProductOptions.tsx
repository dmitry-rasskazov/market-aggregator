import React from 'react';
import Typography from '@mui/material/Typography';
import styles from './ProductOptions.module.css';

interface Option {
  label: string;
  value: string;
}

interface ProductOptionsProps {
  options?: Option[];
}

const defaultOptions: Option[] = [
  { label: 'Категория:', value: 'Ремонт' },
  { label: 'Количество:', value: '100 шт' },
  { label: 'Вес:', value: '10 кг' },
  { label: 'Высота:', value: '20 см' },
  { label: 'Ширина:', value: '50 см' },
  { label: 'Длина:', value: '30 см' },
  { label: 'Опция 6:', value: '1 ед. и.' },
  { label: 'Опция 7:', value: '2 ед. и.' },
  { label: 'Опция 8:', value: '1 ед. и.' },
  { label: 'Опция 9:', value: '1 ед. и.' },
  { label: 'Опция 10:', value: '1 ед. и.' },
  { label: 'Опция 11:', value: '1 ед. и.' },
  { label: 'Опция 12:', value: '1 ед. и.' },
];

const ProductOptions: React.FC<ProductOptionsProps> = ({ options = defaultOptions }) => {
  return (
    <div className={styles.container}>
      {options.map((option, index) => (
        <div key={index} className={styles.optionRow}>
          <div className={styles.optionName}>
            <div className={styles.bullet} />
            <Typography variant="body2">{option.label}</Typography>
          </div>
          <Typography variant="body2" className={styles.optionValue}>{option.value}</Typography>
        </div>
      ))}
    </div>
  );
};

export default ProductOptions;

