import React from 'react';
import styles from './SearchInputComponent.module.css';

interface SearchInputProps {
  className?: string;
  placeholder?: string;
  onChange?: (value: string) => void;
}

const SearchInputComponent: React.FC<SearchInputProps> = ({
  className = '',
  placeholder = 'Поиск...',
  onChange
}) => {
  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (onChange) {
      onChange(e.target.value);
    }
  };

  return (
    <div className={`${styles.searchContainer} ${className}`}>
      <div className={styles.inputWrapper}>
        <input
          type="text"
          className={styles.input}
          placeholder={placeholder}
          onChange={handleInputChange}
        />
        <img 
          src="https://dashboard.codeparrot.ai/api/image/Z9k8ySppvFKitUWW/search.png" 
          alt="Search"
          className={styles.searchIcon}
        />
      </div>
    </div>
  );
};

export default SearchInputComponent;

