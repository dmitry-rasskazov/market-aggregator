import React, { useState } from 'react';
import styles from './SortComponent.module.css';
import Button from '@mui/material/Button';
import Divider from '@mui/material/Divider';

interface SortOption {
  label: string;
  value: string;
  icon: string;
}

const SortComponent: React.FC = () => {
  const [selectedOptions, setSelectedOptions] = useState<string[]>([]);

  const sortOptions: SortOption[] = [
    { label: 'цена', value: 'price', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/minus.png' },
    { label: 'рейтинг продукта', value: 'product_rating', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/minus-2.png' },
    { label: 'рейтинг поставщика', value: 'supplier_rating', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/minus-3.png' },
  ];

  const toggleOption = (value: string) => {
    if (selectedOptions.includes(value)) {
      setSelectedOptions(selectedOptions.filter(option => option !== value));
    } else {
      setSelectedOptions([...selectedOptions, value]);
    }
  };

  return (
    <div className={styles.sortContainer}>
      <h2 className={styles.title}>Сортировать по</h2>
      <Divider className={styles.divider} />
      {sortOptions.map((option) => (
        <div 
          key={option.value}
          className={styles.sortField}
          onClick={() => toggleOption(option.value)}
        >
          <span className={styles.optionLabel}>{option.label}</span>
          <img 
            src={option.icon} 
            alt="sort icon" 
            className={styles.icon}
          />
        </div>
      ))}
      <Button variant="contained" className={styles.applyButton}>
        Применить
      </Button>
    </div>
  );
};

export default SortComponent;

