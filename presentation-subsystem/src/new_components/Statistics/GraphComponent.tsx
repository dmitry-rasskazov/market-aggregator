import React from 'react';
import { Line } from 'react-chartjs-2';
import styles from './GraphComponent.module.css';

interface GraphComponentProps {
  data?: any;
  options?: any;
}

const defaultData = {
  labels: ['январь', 'февраль', 'март', 'апрель', 'май', 'июнь', 'июль', 'август', 'сентябрь', 'окатябрь', 'ноябрь', 'декабрь'],
  datasets: [
    {
      label: 'Dataset 1',
      data: [1000, 1050, 1100, 1150, 1200, 1150, 1100, 1050, 1100, 1150, 1200, 1150],
      borderColor: '#b6b6b6',
      borderWidth: 1,
      fill: false,
    },
  ],
};

const defaultOptions = {
  responsive: true,
  maintainAspectRatio: false,
  scales: {
    x: {
      grid: {
        display: false,
      },
    },
    y: {
      beginAtZero: true,
      grid: {
        color: '#b6b6b6',
      },
    },
  },
};

const GraphComponent: React.FC<GraphComponentProps> = ({ data = defaultData, options = defaultOptions }) => {
  return (
    <div className={styles.graphWrapper}>
      <Line data={data} options={options} />
    </div>
  );
};

export default GraphComponent;

