import { Difficulty } from '../interfaces/difficulty';
import { Cuisine } from '../interfaces/cuisine';
import { RecipeType } from '../interfaces/recipe-type';


export interface Recipe{
    recipeId: number;
    name: string;
    description: string;
    rating: number;
    image: any;
    timePrep: string
    difficulty: Difficulty;
    cuisine: Cuisine;
    recipeType: RecipeType
}